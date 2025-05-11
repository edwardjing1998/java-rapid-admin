package admin.service.mapper;

import admin.dto.C3FileTransferDTO;
import admin.model.C3FileTransfer;
import admin.service.ClientService;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class C3FileTransferMapper {

    private static final Logger logger = LoggerFactory.getLogger(C3FileTransferMapper.class);

    public C3FileTransferDTO toDto(C3FileTransfer entity) {
        if (entity == null) return null;

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
        dto.setDdm(entity.getDdNm());
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
        dto.setBinFileCRLFInf(entity.getBinFileCRLFind());
        dto.setAdminQueryList(entity.getAdminQueryList());
        return dto;
    }

    public C3FileTransfer toEntity(C3FileTransferDTO dto) {
        if (dto == null) return null;
        logger.info("C3FileTransfer::fileTransId {} in toEntity ", dto.getFileTransId());
        C3FileTransfer entity = new C3FileTransfer();
        entity.setFileTransId(dto.getFileTransId());
        entity.setSequenceNr(dto.getSequenceNr());
        entity.setTransferCd(dto.getTransferCd());
        entity.setProtocolNm(dto.getProtocolNm());
        entity.setTransPrgNm(dto.getTransPrgNm());
        entity.setModeNm(dto.getModeNm());
        entity.setSecurityNm(dto.getSecurityNm());
        entity.setIpPortCd(dto.getIpPortCd());
        entity.setListenerSrvNm(dto.getListenerSrvNm());
        entity.setDdNm(dto.getDdNm());
        entity.setOrgTypeCd(dto.getOrgTypeCd());
        entity.setMemberCd(dto.getMemberCd());
        entity.setRecordLengthNr(dto.getRecordLengthNr());
        entity.setBlockSizeNr(dto.getBlockSizeNr());
        entity.setConvertFileCd(dto.getConvertFileCd());
        entity.setXferFileNm(dto.getXferFileNm());
        entity.setJobNm(dto.getJobNm());
        entity.setProgramNm(dto.getProgramNm());
        entity.setRemoteFileNm(dto.getRemoteFileNm());
        entity.setLocalFileNm(dto.getLocalFileNm());
        entity.setControlFileNm(dto.getControlFileNm());
        entity.setGatewayAccessCd(dto.getGatewayAccessCd());
        entity.setBinFileCRLFind(dto.getBinFileCRLFInf());
        entity.setAdminQueryList(dto.getAdminQueryList());
        entity.setLocateFileNm(dto.getLocalFileNm());
        return entity;
    }
}
