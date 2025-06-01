package admin.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "VENDOR")
public class Vendor implements Serializable {

    @Id
    @Column(name = "vend_id", length = 3, nullable = false)
    private String vendId;

    @Column(name = "vend_nm", length = 50, nullable = false)
    private String vendName;

    @Column(name = "vend_actv_cd", nullable = false)
    private Boolean active;

    @Column(name = "vend_rcvr_cd", nullable = false)
    private Boolean vendReceiverCode;

    @Column(name = "vend_fsrv_nm", length = 40)
    private String fileServerName;

    @Column(name = "vend_fsrv_ip", length = 15)
    private String fileServerIp;

    @Column(name = "fsrvr_user_id", length = 10)
    private String fileServerUserId;

    @Column(name = "fsrvr_usr_pwd_tx", length = 50)
    private String fileServerPassword;

    @Column(name = "fsrvr_file_name_tx", length = 50)
    private String fileName;

    @Column(name = "fsrvr_unc_share_tx", length = 255)
    private String uncShare;

    @Column(name = "fsrvr_path_tx", length = 50)
    private String path;

    @Column(name = "fsrvr_file_archive_path_tx", length = 50)
    private String archivePath;

    @Column(name = "vendor_type_cd", length = 1)
    private String vendorTypeCode;

    @Column(name = "vend_file_io", length = 1)
    private String fileIo;

    @Column(name = "vend_client_specific")
    private Boolean clientSpecific;

    @Column(name = "vend_schedule", length = 8)
    private String schedule;

    @Column(name = "vend_date_last_worked", length = 10)
    private String dateLastWorked;

    @Column(name = "vend_filesize")
    private Integer fileSize;

    @Column(name = "vend_filetrans_specs", length = 50)
    private String fileTransferSpecs;

    @Column(name = "vend_file_type")
    private Integer fileType;

    @Column(name = "ftp_passive", length = 5)
    private String ftpPassive;

    @Column(name = "ftp_filetype", length = 1)
    private String ftpFileType;

    public Vendor() {
    }
    public String getVendId()           { return vendId; }
    public void   setVendId(String vendId)  { this.vendId = vendId; }

    public String getVendName()                     { return vendName; }
    public void   setVendName(String vendName)          { this.vendName = vendName; }

    public Boolean getActive()                  { return active; }
    public void    setActive(Boolean active)    { this.active = active; }

    public Boolean getVendReceiverCode()                { return vendReceiverCode; }
    public void    setVendReceiverCode(Boolean vendReceiverCode){ this.vendReceiverCode = vendReceiverCode; }

    public String getFileServerName()           { return fileServerName; }
    public void   setFileServerName(String s)   { this.fileServerName = s; }

    public String getFileServerIp()             { return fileServerIp; }
    public void   setFileServerIp(String s)     { this.fileServerIp = s; }

    public String getFileServerUserId()         { return fileServerUserId; }
    public void   setFileServerUserId(String s) { this.fileServerUserId = s; }

    public String getFileServerPassword()       { return fileServerPassword; }
    public void   setFileServerPassword(String s){ this.fileServerPassword = s; }

    public String getFileName()                 { return fileName; }
    public void   setFileName(String s)         { this.fileName = s; }

    public String getUncShare()                 { return uncShare; }
    public void   setUncShare(String s)         { this.uncShare = s; }

    public String getPath()                     { return path; }
    public void   setPath(String s)             { this.path = s; }

    public String getArchivePath()              { return archivePath; }
    public void   setArchivePath(String s)      { this.archivePath = s; }

    public String getVendorTypeCode()           { return vendorTypeCode; }
    public void   setVendorTypeCode(String s)   { this.vendorTypeCode = s; }

    public String getFileIo()                   { return fileIo; }
    public void   setFileIo(String s)           { this.fileIo = s; }

    public Boolean getClientSpecific()          { return clientSpecific; }
    public void    setClientSpecific(Boolean b) { this.clientSpecific = b; }

    public String  getSchedule()                { return schedule; }
    public void    setSchedule(String s)        { this.schedule = s; }

    public String  getDateLastWorked()          { return dateLastWorked; }
    public void    setDateLastWorked(String s)  { this.dateLastWorked = s; }

    public Integer getFileSize()                { return fileSize; }
    public void    setFileSize(Integer size)    { this.fileSize = size; }

    public String  getFileTransferSpecs()       { return fileTransferSpecs; }
    public void    setFileTransferSpecs(String s){ this.fileTransferSpecs = s; }

    public Integer getFileType()                { return fileType; }
    public void    setFileType(Integer t)       { this.fileType = t; }

    public String  getFtpPassive()              { return ftpPassive; }
    public void    setFtpPassive(String s)      { this.ftpPassive = s; }

    public String  getFtpFileType()             { return ftpFileType; }
    public void    setFtpFileType(String s)     { this.ftpFileType = s; }
}

