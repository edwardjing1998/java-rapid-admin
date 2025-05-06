package admin.dto;

import admin.model.AdminQueryList;

public class C3FileTransferDTO {

    private Integer fileTransId;
    private Integer sequenceNr;
    private Integer transferCd;
    private String protocolNm;
    private String transPrgNm;
    private String modeNm;
    private String securityNm;
    private String ipPortCd;
    private String listenerSrvNm;
    private String ddNm;
    private Integer orgTypeCd;
    private String memberCd;
    private Integer recordLengthNr;
    private Integer blockSizeNr;
    private Integer convertFileCd;
    private String xferFileNm;
    private String jobNm;
    private String programNm;
    private String remoteFileNm;
    private String localFileNm;
    private String controlFileNm;
    private String gatewayAccessCd;

    private String localFileName;

    private Byte binFileCRLFind;
    private Integer adminQueryListId;

    private AdminQueryList adminQueryList; // Reference only, no JPA annotation


    public Integer getFileTransId() {
        return fileTransId;
    }

    public void setFileTransId(Integer fileTransId) {
        this.fileTransId = fileTransId;
    }

    public Integer getSequenceNr() {
        return sequenceNr;
    }

    public void setSequenceNr(Integer sequenceNr) {
        this.sequenceNr = sequenceNr;
    }

    public Integer getTransferCd() {
        return transferCd;
    }

    public void setTransferCd(Integer transferCd) {
        this.transferCd = transferCd;
    }

    public String getProtocolNm() {
        return protocolNm;
    }

    public void setProtocolNm(String protocolNm) {
        this.protocolNm = protocolNm;
    }

    public String getTransPrgNm() {
        return transPrgNm;
    }

    public void setTransPrgNm(String transPrgNm) {
        this.transPrgNm = transPrgNm;
    }

    public String getModeNm() {
        return modeNm;
    }

    public void setModeNm(String modeNm) {
        this.modeNm = modeNm;
    }

    public String getSecurityNm() {
        return securityNm;
    }


    public void setSecurityNm(String securityNm) {
        this.securityNm = securityNm;
    }

    public String getIpPortCd() {
        return ipPortCd;
    }

    public void setIpPortCd(String ipPortCd) {
        this.ipPortCd = ipPortCd;
    }

    public String getListenerSrvNm() {
        return listenerSrvNm;
    }

    public void setListenerSrvNm(String listenerSrvNm) {
        this.listenerSrvNm = listenerSrvNm;
    }

    public String getDdNm() {
        return ddNm;
    }

    public void setDdNm(String ddNm) {
        this.ddNm = ddNm;
    }

    public Integer getOrgTypeCd() {
        return orgTypeCd;
    }

    public void setOrgTypeCd(Integer orgTypeCd) {
        this.orgTypeCd = orgTypeCd;
    }

    public String getMemberCd() {
        return memberCd;
    }

    public void setMemberCd(String memberCd) {
        this.memberCd = memberCd;
    }

    public Integer getRecordLengthNr() {
        return recordLengthNr;
    }

    public void setRecordLengthNr(Integer recordLengthNr) {
        this.recordLengthNr = recordLengthNr;
    }

    public Integer getBlockSizeNr() {
        return blockSizeNr;
    }

    public void setBlockSizeNr(Integer blockSizeNr) {
        this.blockSizeNr = blockSizeNr;
    }

    public Integer getConvertFileCd() {
        return convertFileCd;
    }

    public void setConvertFileCd(Integer convertFileCd) {
        this.convertFileCd = convertFileCd;
    }

    public String getXferFileNm() {
        return xferFileNm;
    }

    public void setXferFileNm(String xferFileNm) {
        this.xferFileNm = xferFileNm;
    }

    public String getJobNm() {
        return jobNm;
    }

    public void setJobNm(String jobNm) {
        this.jobNm = jobNm;
    }

    public String getProgramNm() {
        return programNm;
    }

    public void setProgramNm(String programNm) {
        this.programNm = programNm;
    }

    public String getRemoteFileNm() {
        return remoteFileNm;
    }

    public void setRemoteFileNm(String remoteFileNm) {
        this.remoteFileNm = remoteFileNm;
    }

    public String getLocalFileNm() {
        return localFileNm;
    }

    public void setLocalFileNm(String localFileNm) {
        this.localFileNm = localFileNm;
    }

    public String getControlFileNm() {
        return controlFileNm;
    }

    public void setControlFileNm(String controlFileNm) {
        this.controlFileNm = controlFileNm;
    }

    public String getGatewayAccessCd() {
        return gatewayAccessCd;
    }

    public void setGatewayAccessCd(String gatewayAccessCd) {
        this.gatewayAccessCd = gatewayAccessCd;
    }

    public Byte getBinFileCRLFind() {
        return binFileCRLFind;
    }

    public void setBinFileCRLFind(Byte binFileCRLFind) {
        this.binFileCRLFind = binFileCRLFind;
    }

    public Integer getAdminQueryListId() {
        return adminQueryListId;
    }

    public void setAdminQueryListId(Integer adminQueryListId) {
        this.adminQueryListId = adminQueryListId;
    }

    public void setLocalFileName(String localFileName) {
        this.localFileName = localFileName;
    }

    public String getLocalFileName() {
        return localFileName;
    }

    public AdminQueryList getAdminQueryList() { return adminQueryList; }
    public void setAdminQueryList(AdminQueryList adminQueryList) { this.adminQueryList = adminQueryList; }

}
