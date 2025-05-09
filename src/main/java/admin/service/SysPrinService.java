package admin.service;

import admin.dto.SysPrinDTO;
import admin.model.SysPrin;
import admin.model.SysPrinId;
import admin.repository.SysPrinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysPrinService {

    private static final Logger logger = LoggerFactory.getLogger(SysPrinService.class);

    private final SysPrinRepository sysPrinRepository;

    public SysPrinService(SysPrinRepository sysPrinRepository) {
        this.sysPrinRepository = sysPrinRepository;
    }

    public List<SysPrin> saveSysPrinsForClient(String clientId, List<SysPrinDTO> sysPrinDTOs) {
        List<SysPrin> entities = sysPrinDTOs.stream().map(dto -> {
            SysPrin entity = new SysPrin();
            entity.setId(new SysPrinId(clientId, dto.getSysPrin()));
            entity.setCustType(dto.getCustType());
            entity.setUndeliverable(dto.getUndeliverable());
            entity.setStatA(dto.getStatA());
            entity.setStatB(dto.getStatB());
            entity.setStatC(dto.getStatC());
            entity.setStatD(dto.getStatD());
            entity.setStatE(dto.getStatE());
            entity.setStatF(dto.getStatF());
            entity.setStatI(dto.getStatI());
            entity.setStatL(dto.getStatL());
            entity.setStatO(dto.getStatO());
            entity.setStatU(dto.getStatU());
            entity.setStatX(dto.getStatX());
            entity.setStatZ(dto.getStatZ());
            entity.setPoBox(dto.getPoBox());
            entity.setAddrFlag(dto.getAddrFlag());
            entity.setTempAway(dto.getTempAway());
            entity.setRps(dto.getRps());
            entity.setSession(dto.getSession());
            entity.setBadState(dto.getBadState());
            entity.setAStatRch(dto.getAStatRch());
            entity.setNm13(dto.getNm13());
            entity.setTempAwayAtts(dto.getTempAwayAtts());
            entity.setReportMethod(dto.getReportMethod());
            entity.setActive(dto.getActive());
            entity.setNotes(dto.getNotes());
            entity.setReturnStatus(dto.getReturnStatus());
            entity.setDestroyStatus(dto.getDestroyStatus());
            entity.setNonUS(dto.getNonUS());
            entity.setSpecial(dto.getSpecial());
            entity.setPinMailer(dto.getPinMailer());
            entity.setHoldDays(dto.getHoldDays());
            entity.setForwardingAddress(dto.getForwardingAddress());
            entity.setContact(dto.getContact());
            entity.setPhone(dto.getPhone());
            entity.setEntityCode(dto.getEntityCode());
            return entity;
        }).collect(Collectors.toList());

        return sysPrinRepository.saveAll(entities);
    }

// File: SysPrinService.java

    public List<SysPrinDTO> getSysPrinsByClient(String clientId) {
        List<SysPrin> sysPrins = sysPrinRepository.findByIdClient(clientId);

        return sysPrins.stream().map(sp -> {
            SysPrinDTO dto = new SysPrinDTO();
            dto.setClient(sp.getId().getClient());
            dto.setSysPrin(sp.getId().getSysPrin());
            dto.setCustType(sp.getCustType());
            dto.setUndeliverable(sp.getUndeliverable());
            dto.setStatA(sp.getStatA());
            dto.setStatB(sp.getStatB());
            dto.setStatC(sp.getStatC());
            dto.setStatD(sp.getStatD());
            dto.setStatE(sp.getStatE());
            dto.setStatF(sp.getStatF());
            dto.setStatI(sp.getStatI());
            dto.setStatL(sp.getStatL());
            dto.setStatO(sp.getStatO());
            dto.setStatU(sp.getStatU());
            dto.setStatX(sp.getStatX());
            dto.setStatZ(sp.getStatZ());
            dto.setPoBox(sp.getPoBox());
            dto.setAddrFlag(sp.getAddrFlag());
            dto.setTempAway(sp.getTempAway());
            dto.setRps(sp.getRps());
            dto.setSession(sp.getSession());
            dto.setBadState(sp.getBadState());
            dto.setAStatRch(sp.getAStatRch());
            dto.setNm13(sp.getNm13());
            dto.setTempAwayAtts(sp.getTempAwayAtts());
            dto.setReportMethod(sp.getReportMethod());
            dto.setActive(sp.getActive());
            dto.setNotes(sp.getNotes());
            dto.setReturnStatus(sp.getReturnStatus());
            dto.setDestroyStatus(sp.getDestroyStatus());
            dto.setNonUS(sp.getNonUS());
            dto.setSpecial(sp.getSpecial());
            dto.setPinMailer(sp.getPinMailer());
            dto.setHoldDays(sp.getHoldDays());
            dto.setForwardingAddress(sp.getForwardingAddress());
            dto.setContact(sp.getContact());
            dto.setPhone(sp.getPhone());
            dto.setEntityCode(sp.getEntityCode());

            return dto;
        }).collect(Collectors.toList());
    }

    public List<SysPrinDTO> getSysPrinsBySysPrin(String sysPrin) {
        logger.info("sysprin in getSysPrinsBySysPrin {}", sysPrin);
        List<SysPrin> sysPrins = sysPrinRepository.findByIdSysPrin(sysPrin);
        logger.info("sysprin size in getSysPrinsBySysPrin {}", sysPrins.size());
        return sysPrins.stream().map(sp -> {
            SysPrinDTO dto = new SysPrinDTO();
            dto.populateFromEntity(sp);

            // Set all client IDs that share the same sysPrin
            List<String> allClientIds = sysPrins.stream()
                    .map(p -> p.getId().getClient())
                    .distinct()
                    .collect(Collectors.toList());
            dto.setClientIds(allClientIds);
            logger.info("allClientIds size in getSysPrinsBySysPrin {}", dto.getClientIds().size());
            return dto;
        }).collect(Collectors.toList());
    }


}
