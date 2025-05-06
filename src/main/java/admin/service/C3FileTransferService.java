package admin.service;

import admin.dto.C3FileTransferDTO;
import admin.model.C3FileTransfer;
import admin.model.AdminQueryList;
import admin.repository.C3FileTransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class C3FileTransferService {

    private final C3FileTransferRepository repository;

    public C3FileTransferService(C3FileTransferRepository repository) {
        this.repository = repository;
    }

    public List<C3FileTransferDTO> getAllTransfers() {
        List<C3FileTransfer> entities = repository.findAll();

        return entities.stream().map(entity -> {
            C3FileTransferDTO dto = new C3FileTransferDTO();
            dto.setFileTransId(entity.getFileTransId());
            dto.setSequenceNr(entity.getSequenceNr());
            dto.setTransferCd(entity.getTransferCd());
            dto.setProtocolNm(entity.getProtocolNm());
            dto.setTransPrgNm(entity.getTransPrgNm());
            dto.setModeNm(entity.getModeNm());
            dto.setSecurityNm(entity.getSecurityNm());
            dto.setIpPortCd(entity.getIpPortCd());
            dto.setListenerSrvNm(entity.getListenerSrvNm());
            dto.setDdNm(entity.getDdNm());
            dto.setOrgTypeCd(entity.getOrgTypeCd());
            dto.setMemberCd(entity.getMemberCd());
            dto.setRecordLengthNr(entity.getRecordLengthNr());
            dto.setBlockSizeNr(entity.getBlockSizeNr());
            dto.setConvertFileCd(entity.getConvertFileCd());
            dto.setXferFileNm(entity.getXferFileNm());
            dto.setJobNm(entity.getJobNm());
            dto.setProgramNm(entity.getProgramNm());
            dto.setRemoteFileNm(entity.getRemoteFileNm());
            dto.setLocalFileNm(entity.getLocalFileNm());
            dto.setControlFileNm(entity.getControlFileNm());
            dto.setGatewayAccessCd(entity.getGatewayAccessCd());
            dto.setBinFileCRLFind(entity.getBinFileCRLFind());
            dto.setLocalFileName(entity.getLocalFileName());

            AdminQueryList adminQueryList = entity.getAdminQueryList();
            if (adminQueryList != null) {
                dto.setAdminQueryList(adminQueryList);
            }

            return dto;
        }).collect(Collectors.toList());
    }
}
