package admin.service;

import admin.dto.*;
import admin.model.*;
import admin.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ClientDTO> getAllClientsWithDetails() {
        logger.info("Fetching all clients with full details...");
        
        List<Client> clients = clientRepository.findAll();
        logger.info("Total clients found: {}", clients.size());

        return clients.stream().map(client -> {
            logger.debug("Processing client: {}", client.getClient());

            ClientDTO dto = new ClientDTO();
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

            List<ClientReportOptionDTO> reportOptionDTOs = client.getReportOptions().stream()
                    .map(ro -> {
                        AdminQueryList report = ro.getReport();
                        AdminQueryListDTO reportDetails = null;
                        if (report != null) {
                            reportDetails = new AdminQueryListDTO(report);
                        }

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
            dto.setReportOptions(reportOptionDTOs);

            List<SysPrinsPrefix> prefixes = sysPrinsPrefixRepository.findByIdBillingSp(client.getBillingSp());
            List<SysPrinsPrefixDTO> sysPrinsDTOs = prefixes.stream()
                    .map(sp -> new SysPrinsPrefixDTO(
                            sp.getId().getBillingSp(),
                            sp.getId().getPrefix(),
                            sp.getId().getAtmCashRule()
                    )).collect(Collectors.toList());
            dto.setSysPrinsPrefixes(sysPrinsDTOs);

            List<SysPrin> sysPrins = sysPrinRepository.findByIdClient(client.getClient());

            // ✅ 1. Collect all sysPrin IDs
            List<String> sysPrinIds = sysPrins.stream()
                    .map(sp -> sp.getId().getSysPrin())
                    .collect(Collectors.toList());

            // ✅ 2. One query to fetch all InvalidDelivAreas
            List<InvalidDelivArea> allInvalidDelivAreas = invalidDelivAreaRepository.findByIdSysPrinIn(sysPrinIds);

            // ✅ 3. Group by sysPrin
            var invalidDelivAreaMap = allInvalidDelivAreas.stream()
                    .collect(Collectors.groupingBy(InvalidDelivArea::getSysPrin));


            List<SysPrinDTO> sysPrinDTOs = sysPrins.stream().map(sp -> {
                SysPrinDTO sysDto = new SysPrinDTO();
                sysDto.setClient(sp.getId().getClient());
                sysDto.setSysPrin(sp.getId().getSysPrin());
                sysDto.setCustType(sp.getCustType());
                sysDto.setUndeliverable(sp.getUndeliverable());
                sysDto.setStatA(sp.getStatA());
                sysDto.setStatB(sp.getStatB());
                sysDto.setStatC(sp.getStatC());
                sysDto.setStatD(sp.getStatD());
                sysDto.setStatE(sp.getStatE());
                sysDto.setStatF(sp.getStatF());
                sysDto.setStatI(sp.getStatI());
                sysDto.setStatL(sp.getStatL());
                sysDto.setStatO(sp.getStatO());
                sysDto.setStatU(sp.getStatU());
                sysDto.setStatX(sp.getStatX());
                sysDto.setStatZ(sp.getStatZ());
                sysDto.setPoBox(sp.getPoBox());
                sysDto.setAddrFlag(sp.getAddrFlag());
                sysDto.setTempAway(sp.getTempAway());
                sysDto.setRps(sp.getRps());
                sysDto.setSession(sp.getSession());
                sysDto.setBadState(sp.getBadState());
                sysDto.setAStatRch(sp.getAStatRch());
                sysDto.setNm13(sp.getNm13());
                sysDto.setTempAwayAtts(sp.getTempAwayAtts());
                sysDto.setReportMethod(sp.getReportMethod());
                sysDto.setActive(sp.getActive());
                sysDto.setNotes(sp.getNotes());
                sysDto.setReturnStatus(sp.getReturnStatus());
                sysDto.setDestroyStatus(sp.getDestroyStatus());
                sysDto.setNonUS(sp.getNonUS());
                sysDto.setSpecial(sp.getSpecial());
                sysDto.setPinMailer(sp.getPinMailer());
                sysDto.setHoldDays(sp.getHoldDays());
                sysDto.setForwardingAddress(sp.getForwardingAddress());


                // ✅ 4. Now directly pick the list from map
                List<InvalidDelivAreaDTO> areaDTOs = invalidDelivAreaMap.getOrDefault(sp.getId().getSysPrin(), List.of())
                        .stream()
                        .map(area -> {
                            InvalidDelivAreaDTO areaDto = new InvalidDelivAreaDTO();
                            areaDto.setArea(area.getArea());
                            areaDto.setSysPrin(area.getSysPrin());
                            return areaDto;
                        })
                        .collect(Collectors.toList());

                sysDto.setInvalidDelivAreas(areaDTOs);

                return sysDto;
            }).collect(Collectors.toList());
            dto.setSysPrins(sysPrinDTOs);

            List<ClientEmail> clientEmails = clientEmailRepository.findByIdClientId(client.getClient());
            List<ClientEmailDTO> emailDTOs = clientEmails.stream().map(email -> {
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
            dto.setClientEmail(emailDTOs);

            return dto;
        }).collect(Collectors.toList());
    }

    public Client saveClient(Client client) {
        logger.info("Saving new client: {}", client.getClient());
        return clientRepository.save(client);
    }
}
