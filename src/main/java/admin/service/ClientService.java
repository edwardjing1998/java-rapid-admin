package admin.service;

import admin.dto.*;
import admin.model.*;
import admin.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.cache.annotation.Cacheable;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;
    private final SysPrinRepository sysPrinRepository;
    private final SysPrinsPrefixRepository sysPrinsPrefixRepository;
    private final ClientEmailRepository clientEmailRepository;
    private final InvalidDelivAreaRepository invalidDelivAreaRepository;

    public ClientService(ClientRepository clientRepository,
                         SysPrinRepository sysPrinRepository,
                         SysPrinsPrefixRepository sysPrinsPrefixRepository,
                         ClientEmailRepository clientEmailRepository,
                         InvalidDelivAreaRepository invalidDelivAreaRepository) {
        this.clientRepository = clientRepository;
        this.sysPrinRepository = sysPrinRepository;
        this.sysPrinsPrefixRepository = sysPrinsPrefixRepository;
        this.clientEmailRepository = clientEmailRepository;
        this.invalidDelivAreaRepository = invalidDelivAreaRepository;
    }

    @Cacheable("allClients")
    public List<ClientDTO> getClientsWithPaginations(Pageable pageable) {
        logger.info("Fetching paginated clients with full details...");
        Page<Client> page = clientRepository.getClientsWithPaginations(pageable);
        List<Client> clients = page.getContent();

        logger.info("Total clients found: {}", clients.size());
        return clients.stream().map(this::mapClientToDto).collect(Collectors.toList());
    }

    @Cacheable("allClients")
    public List<ClientDTO> getAllClients() {
        logger.info("Fetching All clients with full details...");
        List<Client> clients = clientRepository.getAllClients();
        logger.info("Total clients found: {}", clients.size());
        return clients.stream().map(this::mapClientToDto).collect(Collectors.toList());
    }

    private ClientDTO mapClientToDto(Client client) {
        logger.debug("Processing client: {}", client.getClient());
        ClientDTO dto = new ClientDTO();

        // Basic Info
        dto.setClient(client.getClient());
        dto.setName(client.getName());
        dto.setAddr(client.getAddr());
        dto.setCity(client.getCity());
        dto.setState(client.getState());
        dto.setZip(client.getZip());
        dto.setContact(client.getContact());
        dto.setPhone(client.getPhone());
        dto.setActive(client.getActive());
        dto.setFaxNumber(client.getFaxNumber());
        dto.setBillingSp(client.getBillingSp());
        dto.setReportBreakFlag(client.getReportBreakFlag());
        dto.setChLookUpType(client.getChLookUpType());
        dto.setExcludeFromReport(client.getExcludeFromReport());
        dto.setPositiveReports(client.getPositiveReports());
        dto.setSubClientInd(client.getSubClientInd());
        dto.setSubClientXref(client.getSubClientXref());
        dto.setAmexIssued(client.getAmexIssued());

        dto.setReportOptions(mapClientReportOptions(client));
        dto.setSysPrinsPrefixes(mapSysPrinsPrefixes(client.getBillingSp()));
        dto.setSysPrins(mapSysPrinsDtos(client));
        dto.setClientEmail(mapClientEmails(client));

        return dto;
    }

    private List<ClientReportOptionDTO> mapClientReportOptions(Client client) {
        return client.getReportOptions().stream().map(ro -> {
            AdminQueryList report = ro.getReport();
            AdminQueryListDTO reportDetails = (report != null) ? new AdminQueryListDTO(report) : null;

            ClientReportOptionDTO optionDTO = new ClientReportOptionDTO(
                    ro.getId().getClientId(),
                    ro.getId().getReportId(),
                    ro.getReceiveFlag(),
                    ro.getOutputTypeCd(),
                    ro.getFileTypeCd(),
                    ro.getEmailFlag(),
                    ro.getEmailBodyTx(),
                    ro.getReportPasswordTx()
            );
            optionDTO.setClientId(client.getClient());
            optionDTO.setReportDetails(reportDetails);
            return optionDTO;
        }).collect(Collectors.toList());
    }

    private List<SysPrinsPrefixDTO> mapSysPrinsPrefixes(String billingSp) {
        return sysPrinsPrefixRepository.findByIdBillingSp(billingSp).stream()
                .map(sp -> new SysPrinsPrefixDTO(
                        sp.getId().getBillingSp(),
                        sp.getId().getPrefix(),
                        sp.getId().getAtmCashRule()
                )).collect(Collectors.toList());
    }

    private List<SysPrinDTO> mapSysPrinsDtos(Client client) {
        List<SysPrin> sysPrins = sysPrinRepository.findByIdClient(client.getClient());
        List<String> sysPrinIds = sysPrins.stream().map(sp -> sp.getId().getSysPrin()).collect(Collectors.toList());
        List<InvalidDelivArea> allInvalidDelivAreas = findInvalidDelivAreasInBatches(sysPrinIds);
        Map<String, List<InvalidDelivArea>> invalidDelivAreaMap = allInvalidDelivAreas.stream()
                .collect(Collectors.groupingBy(InvalidDelivArea::getSysPrin));

        return sysPrins.stream().map(sp -> {
            SysPrinDTO sysDto = new SysPrinDTO();
            sysDto.populateFromEntity(sp);

            List<InvalidDelivAreaDTO> areaDTOs = invalidDelivAreaMap.getOrDefault(sp.getId().getSysPrin(), List.of())
                    .stream().map(area -> {
                        InvalidDelivAreaDTO areaDto = new InvalidDelivAreaDTO();
                        areaDto.setArea(area.getArea());
                        areaDto.setSysPrin(area.getSysPrin());
                        return areaDto;
                    }).collect(Collectors.toList());

            sysDto.setInvalidDelivAreas(areaDTOs);
            return sysDto;
        }).collect(Collectors.toList());
    }

    private List<ClientEmailDTO> mapClientEmails(Client client) {
        return clientEmailRepository.findByIdClientId(client.getClient()).stream().map(email -> {
            ClientEmailDTO emailDto = new ClientEmailDTO();
            emailDto.setClientId(email.getId().getClientId());
            emailDto.setReportId(email.getReportId());
            emailDto.setEmailNameTx(email.getEmailNameTx());
            emailDto.setEmailAddressTx(email.getId().getEmailAddressTx());
            emailDto.setCarbonCopyFlag(email.getCarbonCopyFlag());
            emailDto.setActiveFlag(email.getActiveFlag());
            emailDto.setMailServerId(email.getMailServerId());
            return emailDto;
        }).collect(Collectors.toList());
    }

    private static final int BATCH_SIZE = 2000;

    private List<InvalidDelivArea> findInvalidDelivAreasInBatches(List<String> sysPrins) {
        List<InvalidDelivArea> results = new ArrayList<>();
        for (int i = 0; i < sysPrins.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, sysPrins.size());
            List<String> batch = sysPrins.subList(i, end);
            results.addAll(invalidDelivAreaRepository.findByIdSysPrinIn(batch));
        }
        return results;
    }

    public Client saveClient(Client client) {
        logger.info("Saving new client: {}", client.getClient());
        return clientRepository.save(client);
    }
}
