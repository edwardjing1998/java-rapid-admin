package admin.service;

import admin.dto.*;
import admin.model.*;
import admin.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final SysPrinRepository sysPrinRepository;
    private final SysPrinsPrefixRepository sysPrinsPrefixRepository;
    private final ClientEmailRepository clientEmailRepository;

    public ClientService(ClientRepository clientRepository,
                         SysPrinRepository sysPrinRepository,
                         SysPrinsPrefixRepository sysPrinsPrefixRepository,
                         ClientEmailRepository clientEmailRepository) {
        this.clientRepository = clientRepository;
        this.sysPrinRepository = sysPrinRepository;
        this.sysPrinsPrefixRepository = sysPrinsPrefixRepository;
        this.clientEmailRepository = clientEmailRepository;
    }

    public List<ClientDTO> getAllClientsWithDetails() {
        return clientRepository.findAll().stream().map(client -> {
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
                            reportDetails = new AdminQueryListDTO();
                            reportDetails.setReportId(report.getReportId());
                            reportDetails.setReportName(report.getReportName());
                            reportDetails.setReportByClientFlag(report.getReportByClientFlag());
                            reportDetails.setCreatedAt(report.getCreatedAt());
                            reportDetails.setUpdatedAt(report.getUpdatedAt());
                        }

                        ClientReportOptionDTO optionDTO = new ClientReportOptionDTO(
                                ro.getId(),
                                ro.getReportId(),
                                ro.getReceiveFlag(),
                                ro.getOutputTypeCd(),
                                ro.getFileTypeCd(),
                                ro.getEmailFlag(),
                                ro.getReportPasswordTx()
                        );
                        optionDTO.setClientId(client.getClient());
                        optionDTO.setReportDetails(reportDetails);
                        return optionDTO;
                    }).collect(Collectors.toList());
            dto.setReportOptions(reportOptionDTOs);

            List<SysPrinsPrefix> prefixes = sysPrinsPrefixRepository.findByBillingSp(client.getBillingSp());
            List<SysPrinsPrefixDTO> sysPrinsDTOs = prefixes.stream()
                    .map(sp -> new SysPrinsPrefixDTO(
                            sp.getBillingSp(),
                            sp.getPrefix(),
                            sp.getAtmCashRule()
                    )).collect(Collectors.toList());
            dto.setSysPrinsPrefixes(sysPrinsDTOs);

            List<SysPrin> sysPrins = sysPrinRepository.findByIdClient(client.getClient());
            List<SysPrinDTO> sysPrinDTOs = sysPrins.stream().map(sp -> {
                SysPrinDTO sysDto = new SysPrinDTO();
                sysDto.setClient(sp.getId().getClient());
                sysDto.setSysPrin(sp.getId().getSysPrin());
                sysDto.setCustType(sp.getCustType());
                sysDto.setStartDate(sp.getStartDate());
                sysDto.setUndeliverable(sp.getUndeliverable());
                sysDto.setStatA(sp.getStatA());
                sysDto.setStatB(sp.getStatB());
                sysDto.setStatC(sp.getStatC());
                sysDto.setStatD(sp.getStatD());
                sysDto.setStatE(sp.getStatE());
                sysDto.setStatF(sp.getStatF());
                sysDto.setStatG(sp.getStatG());
                sysDto.setStatH(sp.getStatH());
                sysDto.setStatI(sp.getStatI());
                sysDto.setStatJ(sp.getStatJ());
                sysDto.setStatK(sp.getStatK());
                sysDto.setStatL(sp.getStatL());
                sysDto.setStatM(sp.getStatM());
                sysDto.setStatN(sp.getStatN());
                sysDto.setStatO(sp.getStatO());
                sysDto.setStatP(sp.getStatP());
                sysDto.setStatQ(sp.getStatQ());
                sysDto.setStatR(sp.getStatR());
                sysDto.setStatS(sp.getStatS());
                sysDto.setStatT(sp.getStatT());
                sysDto.setStatU(sp.getStatU());
                sysDto.setStatV(sp.getStatV());
                sysDto.setStatW(sp.getStatW());
                sysDto.setStatX(sp.getStatX());
                sysDto.setStatY(sp.getStatY());
                sysDto.setStatZ(sp.getStatZ());
                sysDto.setPoBox(sp.getPoBox());
                sysDto.setNoRenewal(sp.getNoRenewal());
                sysDto.setBlockCard(sp.getBlockCard());
                sysDto.setAddrFlag(sp.getAddrFlag());
                sysDto.setTempAway(sp.getTempAway());
                sysDto.setRsp(sp.getRsp());
                sysDto.setSession(sp.getSession());
                sysDto.setBadState(sp.getBadState());
                sysDto.setAStatRch(sp.getAStatRch());
                sysDto.setNm13(sp.getNm13());
                sysDto.setTempAwayAtts(sp.getTempAwayAtts());
                sysDto.setReportMethod(sp.getReportMethod());
                sysDto.setContact(sp.getContact());
                sysDto.setPhone(sp.getPhone());
                sysDto.setActive(sp.getActive());
                sysDto.setNotes(sp.getNotes());
                sysDto.setReturnStatus(sp.getReturnStatus());
                sysDto.setDestroyStatus(sp.getDestroyStatus());
                sysDto.setNonUS(sp.getNonUS());
                sysDto.setSpecial(sp.getSpecial());
                sysDto.setPinMailer(sp.getPinMailer());
                sysDto.setHoldDays(sp.getHoldDays());

                List<InvalidDelivAreaDTO> areaDTOs = sp.getInvalidDelivAreas().stream().map(area -> {
                    InvalidDelivAreaDTO areaDto = new InvalidDelivAreaDTO();
                    areaDto.setId(area.getId());
                    areaDto.setArea(area.getArea());
                    areaDto.setClient(sp.getId().getClient());
                    areaDto.setSysPrin(sp.getId().getSysPrin());
                    return areaDto;
                }).collect(Collectors.toList());
                sysDto.setInvalidDelivAreas(areaDTOs);

                return sysDto;
            }).collect(Collectors.toList());
            dto.setSysPrins(sysPrinDTOs);

            List<ClientEmail> clientEmails = clientEmailRepository.findByClientId(client.getClient());
            List<ClientEmailDTO> emailDTOs = clientEmails.stream().map(email -> {
                ClientEmailDTO emailDto = new ClientEmailDTO();
                emailDto.setId(email.getId());
                emailDto.setClientId(email.getClientId());
                emailDto.setReportId(email.getReportId());
                emailDto.setEmailName(email.getEmailName());
                emailDto.setEmailAddress(email.getEmailAddress());
                emailDto.setCarbonCopyFlag(email.getCarbonCopyFlag());
                emailDto.setActiveFlag(email.getActiveFlag());
                emailDto.setMailServerId(email.getMailServerId());
                emailDto.setCreatedAt(email.getCreatedAt());
                emailDto.setUpdatedAt(email.getUpdatedAt());
                return emailDto;
            }).collect(Collectors.toList());
            dto.setClientEmail(emailDTOs);

            return dto;
        }).collect(Collectors.toList());
    }
}