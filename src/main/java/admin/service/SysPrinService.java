package admin.service;

import admin.dto.SysPrinDTO;
import admin.model.SysPrin;
import admin.model.SysPrinId;
import admin.repository.SysPrinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysPrinService {

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
            return entity;
        }).collect(Collectors.toList());

        return sysPrinRepository.saveAll(entities);
    }
}
