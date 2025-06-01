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

    private final VendorRepository vendorRepository;


    private final VendorSentToRepository     vendorSentToRepository;


    public ClientService(ClientRepository clientRepository,
                         SysPrinRepository sysPrinRepository,
                         SysPrinsPrefixRepository sysPrinsPrefixRepository,
                         ClientEmailRepository clientEmailRepository,
                         InvalidDelivAreaRepository invalidDelivAreaRepository,
                         VendorSentToRepository     vendorSentToRepository,
                         VendorRepository vendorRepository) {
        this.clientRepository = clientRepository;
        this.sysPrinRepository = sysPrinRepository;
        this.sysPrinsPrefixRepository = sysPrinsPrefixRepository;
        this.clientEmailRepository = clientEmailRepository;
        this.invalidDelivAreaRepository = invalidDelivAreaRepository;
        this.vendorSentToRepository = vendorSentToRepository;
        this.vendorRepository = vendorRepository;
    }

    @Cacheable("allClients")
    public List<ClientDTO> getClientsWithPaginations(Pageable pageable) {
        logger.info("Fetching paginated clients with full details...");
        Page<Client> page = clientRepository.getClientsWithPaginations(pageable);
        List<Client> clients = page.getContent();
        logger.info("Total clients found: {}", clients.size());
        logger.info("The first record {}", clients.get(0));
        return clients.stream().map(this::mapClientToDto).collect(Collectors.toList());
    }

    @Cacheable("allClients")
    public List<ClientDTO> getAllClients() {
        logger.info("Fetching All clients with full details...");
        List<Client> clients = clientRepository.getAllClients();
        logger.info("Total clients found: {}", clients.size());
        return clients.stream().map(this::mapClientToDto).collect(Collectors.toList());
    }

    public Optional<ClientDTO> getClientById(String clientId) {
        return clientRepository.findById(clientId)
                .map(this::mapClientToDto);
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
        List<String> sysPrinIds = sysPrins.stream()
                .map(sp -> sp.getId().getSysPrin())
                .toList();

        List<InvalidDelivArea> allInvalidDelivAreas = findInvalidDelivAreasInBatches(sysPrinIds);
        List<VendorSentTo> allVendorSentTo = findVendorSentToInBatches(sysPrinIds);

        Map<String, List<InvalidDelivArea>> invalidMap = allInvalidDelivAreas.stream()
                .collect(Collectors.groupingBy(InvalidDelivArea::getSysPrin));

        Map<String, List<VendorSentTo>> vendorMap = allVendorSentTo.stream()
                .collect(Collectors.groupingBy(v -> v.getId().getSysPrin()));



        return sysPrins.stream().map(sp -> {
            SysPrinDTO dto = new SysPrinDTO();
            dto.populateFromEntity(sp);

            List<InvalidDelivAreaDTO> areaDTOs = invalidMap
                    .getOrDefault(sp.getId().getSysPrin(), List.of())
                    .stream()
                    .map(a -> new InvalidDelivAreaDTO(a.getArea(), a.getSysPrin()))
                    .toList();
            dto.setInvalidDelivAreas(areaDTOs);

            Map<String,String> fileSentTovendorNameMap = buildVendorNameMap(allVendorSentTo, "I");

            List<VendorSentToDTO> sentToDTOs = buildVendorSentToDTOs(
                    vendorMap.getOrDefault(sp.getId().getSysPrin(), List.of()),
                    fileSentTovendorNameMap
            );
            dto.setVendorSentTo(sentToDTOs);

            Map<String,String> receivedFromvendorNameMap = buildVendorNameMap(allVendorSentTo, "O");

            List<VendorRecivedFromDTO> receivedFromDTOs = buildVendorRecivedFromDTOs(
                    vendorMap.getOrDefault(sp.getId().getSysPrin(), List.of()),
                    receivedFromvendorNameMap
            );

            dto.setVendorReceivedFrom(receivedFromDTOs);
            return dto;
        }).toList();
    }

    /**
     * Load all distinct vendIds, filter by fileIo="I", and
     * return a vendId→vendName map.
     */
    private Map<String,String> buildVendorNameMap(List<VendorSentTo> sentToRecords, String fileIo) {
        var vendIds = sentToRecords.stream()
                .map(v -> v.getId().getVendId())
                .distinct()
                .toList();

        return vendorRepository.findAllById(vendIds)
                .stream()
                .filter(vendor -> fileIo.equalsIgnoreCase(vendor.getFileIo()))
                .collect(Collectors.toMap(
                        Vendor::getVendId,
                        Vendor::getVendName
                ));
    }

    /**
     * Turn a list of VendorSentTo entities into DTOs,
     * dropping any whose name lookup is missing.
     */
    private List<VendorSentToDTO> buildVendorSentToDTOs(
            List<VendorSentTo> records,
            Map<String,String> vendorNameMap
    ) {
        return records.stream()
                .filter(v -> vendorNameMap.containsKey(v.getId().getVendId()))
                .map(v -> {
                    VendorSentToDTO d = new VendorSentToDTO();
                    d.setSysPrin(v.getId().getSysPrin());
                    d.setVendorId(v.getId().getVendId());
                    d.setVendorName(vendorNameMap.get(v.getId().getVendId()));
                    d.setQueForMail(v.getQueForMail());
                    return d;
                })
                .toList();
    }

    private List<VendorRecivedFromDTO> buildVendorRecivedFromDTOs(
            List<VendorSentTo> records,
            Map<String,String> vendorNameMap
    ) {
        return records.stream()
                .filter(v -> vendorNameMap.containsKey(v.getId().getVendId()))
                .map(v -> {
                    VendorRecivedFromDTO d = new VendorRecivedFromDTO();
                    d.setSysPrin(v.getId().getSysPrin());
                    d.setVendorId(v.getId().getVendId());
                    d.setVendorName(vendorNameMap.get(v.getId().getVendId()));
                    d.setQueForMail(v.getQueForMail());
                    return d;
                })
                .toList();
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

    public List<ClientSearchDTO> getClientSearch() {
        logger.info("Fetching All clients in getClientSearch...");
        List<Object[]> rawResults = clientRepository.findAllClientNamesNative();
        logger.info("All clients {} in getClientSearch...", rawResults.size());
        return rawResults.stream()
                .map(row -> new ClientSearchDTO(
                        (String) row[0],
                        (String) row[1]
                ))
                .collect(Collectors.toList());
    }

    public List<ClientDTO> searchClientsByWildcard(String keyword) {
        List<Client> clients = clientRepository.searchClientsByKeyword(keyword);
        logger.info("the size of records {} in ClientService::searchClientsByWildcard", clients.size());
        return clients.stream().map(this::mapClientToDto).collect(Collectors.toList());
    }

    private List<VendorSentTo> findVendorSentToInBatches(List<String> sysPrins) {
        List<VendorSentTo> results = new ArrayList<>();
        for (int i = 0; i < sysPrins.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, sysPrins.size());
            List<String> slice = sysPrins.subList(i, end);
            results.addAll(vendorSentToRepository.findByIdSysPrinIn(slice));
        }
        return results;
    }
}
