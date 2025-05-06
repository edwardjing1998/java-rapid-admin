package admin.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "c3_transfer_parameters")
public class C3FileTransfer {

    @Id
    @Column(name = "file_trns_id" , nullable = false)
    private Integer fileTransId;

    @Column(name = "sequence_nr", nullable = false)
    private Integer sequenceNr;

    @Column(name = "transfer_cd", nullable = false)
    private Integer transferCd;

    @Column(name = "protocol_nm", nullable = false, length = 100)
    private String protocolNm;

    @Column(name = "trans_prg_nm", nullable = false, length = 100)
    private String transPrgNm;

    @Column(name = "mode_nm", nullable = false, length = 100)
    private String modeNm;

    @Column(name = "security_nm", nullable = false, length = 100)
    private String securityNm;

    @Column(name = "ip_port_cd", nullable = false , length = 100)
    private String ipPortCd;

    @Column(name = "listener_srv_nm", nullable = false, length = 100)
    private String listenerSrvNm;

    @Column(name = "dd_nm", nullable = false, length = 100)
    private String ddNm;

    @Column(name = "org_type_cd", nullable = false, length = 100)
    private String OrgTypeCd;

    @Column(name = "member_cd", nullable = false, length = 100)
    private String memberCd;

    @Column(name = "record_lgth_nr", nullable = false)
    private Integer recordLgthNr;

    @Column(name = "block_size_nr", nullable = false)
    private Integer blockSizeNr;

    @Column(name = "convert_file_cd", nullable = false)
    private Integer convertFileCd;

    @Column(name = "xfer_file_nm" , nullable = false , length = 100)
    private String xferFileNm;

    @Column(name = "job_nm" , nullable = false , length = 100)
    private String jobNm;

    @Column(name = "program_nm", nullable = false , length = 100)
    private String programNm;

    @Column(name = "remote_file_nm", nullable = false , length = 100)
    private String remoteFileNm;

    @Column(name = "local_file_nm", nullable = false, length = 100)
    private String localFileNm;

    @Column(name = "control_file_nm", nullable = false, length = 100)
    private String controlFileNm;

    @Column(name = "gateway_access_cd" , nullable = false , length = 100)
    private String gatewayAccessCd;

    @Column(name = "bin_file_CRLF_ind")
    private Byte binFileCRLFind;

    @OneToOne
    @JoinColumn(name = "file_trns_id", referencedColumnName = "report_id")
    private AdminQueryList adminQueryList;

    public void SetFileTransId(Integer fileTransId) {
        this.fileTransId = fileTransId;
    }
    public Integer GetFileTransId() {
        return fileTransId;
    }

    public void SetSequenceNr(Integer sequenceNr) {
        this.sequenceNr = sequenceNr;
    }

    public Integer GetSequenceNr() {
        return sequenceNr;
    }

    public void SetTransferCd(Integer transferCd) {
        this.transferCd = transferCd;
    }

    public Integer GetTransferCd() {
        return transferCd;
    }

    public void SetProtocolNm(String protocolNm) {
        this.protocolNm = protocolNm;
    }

    public String GetProtocolNm() {
        return protocolNm;
    }

    public void SetTransPrgNm(String transPrgNm) {
        this.transPrgNm = transPrgNm;
    }

    public String GetTransPrgNm() {
        return transPrgNm;
    }

    public void SetModeNm(String modeNm) {
        this.modeNm = modeNm;
    }
    public String GetModeNm() {
        return modeNm;
    }

    public void SetSecurityNm(String securityNm) {
        this.securityNm = securityNm;
    }

    public String GetSecurityNm() {
        return securityNm;
    }

    public void SetIpPortCd(String ipPortCd) {
        this.ipPortCd = ipPortCd;
    }

    public String GetIpPortCd() {
        return ipPortCd;
    }

    public void SetListenerSrvNm(String listenerSrvNm) {
        this.listenerSrvNm = listenerSrvNm;
    }

    public String GetListenerSrvNm() {
        return listenerSrvNm;
    }

    public void SetDdNm(String ddNm) {
        this.ddNm = ddNm;
    }

    public String GetDdNm() {
        return ddNm;
    }

    public void SetOrgTypeCd(String orgTypeCd) {
        this.OrgTypeCd = orgTypeCd;
    }

    public String GetOrgTypeCd() {
        return OrgTypeCd;
    }

    public void SetMemberCd(String memberCd) {
        this.memberCd = memberCd;
    }

    public String GetMemberCd() {
        return memberCd;
    }

    public void SetRecordLengthNr(Integer recordLengthNr) {
        this.recordLgthNr = recordLgthNr;
    }

    public Integer GetRecordLengthNr() {
        return recordLgthNr;
    }

    public void SetBlockSizeNr(Integer blockSizeNr) {
        this.blockSizeNr = blockSizeNr;
    }

    public Integer GetBlockSizeNr() {
        return blockSizeNr;
    }

    public void SetConvertFileCd(Integer convertFileCd) {
        this.convertFileCd = convertFileCd;
    }

    public Integer GetConvertFileCd() {
        return convertFileCd;
    }

    public void SetXferFileNm(String xferFileNm) {
        this.xferFileNm = xferFileNm;

    }

    public String GetXferFileNm() {
        return xferFileNm;
    }

    public void SetJobNm(String jobNm) {
        this.jobNm = jobNm;
    }

    public String GetJobNm() {
        return jobNm;
    }

    public void SetProgramNm(String programNm) {
        this.programNm = programNm;
    }

    public String GetProgramNm() {
        return programNm;
    }

    public void SetRemoteFileNm(String remoteFileNm) {
        this.remoteFileNm = remoteFileNm;
    }

    public String GetRemoteFileNm() {
        return remoteFileNm;
    }

    public void SetLocalFileNm(String localFileNm) {
        this.localFileNm = localFileNm;
    }

    public String GetLocalFileNm() {
        return localFileNm;
    }

    public void SetControlFileNm(String controlFileNm) {
        this.controlFileNm = controlFileNm;
    }

    public String GetControlFileNm() {
        return controlFileNm;
    }

    public void SetGatewayAccessCd(String gatewayAccessCd) {
        this.gatewayAccessCd = gatewayAccessCd;
    }

    public String GetGatewayAccessCd() {
        return gatewayAccessCd;
    }

    public void SetBinFileCRLFind(Byte binFileCRLFind) {
        this.binFileCRLFind = binFileCRLFind;
    }

    public Byte GetBinFileCRLFind() {
        return binFileCRLFind;
    }
}