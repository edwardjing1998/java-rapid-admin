package admin.dto;

import java.io.Serializable;

public class VendorDTO implements Serializable {

    private String  id;                    // vend_id
    private String  name;                  // vend_nm
    private Boolean active;                // vend_actv_cd
    private Boolean receiver;              // vend_rcvr_cd

    private String  fileServerName;        // vend_fsrv_nm
    private String  fileServerIp;          // vend_fsrv_ip
    private String  fileServerUserId;      // fsrvr_user_id
    private String  fileServerPassword;    // fsrvr_usr_pwd_tx
    private String  fileName;              // fsrvr_file_name_tx
    private String  uncShare;              // fsrvr_unc_share_tx
    private String  path;                  // fsrvr_path_tx
    private String  archivePath;           // fsrvr_file_archive_path_tx

    private String  vendorTypeCode;        // vendor_type_cd
    private String  fileIo;                // vend_file_io
    private Boolean clientSpecific;        // vend_client_specific

    private String  schedule;              // vend_schedule
    private String  dateLastWorked;        // vend_date_last_worked

    private Integer fileSize;              // vend_filesize
    private String  fileTransferSpecs;     // vend_filetrans_specs
    private Integer fileType;              // vend_file_type

    private String  ftpPassive;            // ftp_passive
    private String  ftpFileType;           // ftp_filetype

    /* ---------- constructors ---------- */

    public VendorDTO() {
    }

    public String  getId()                     { return id; }
    public void    setId(String id)            { this.id = id; }

    public String  getName()                   { return name; }
    public void    setName(String name)        { this.name = name; }

    public Boolean getActive()                 { return active; }
    public void    setActive(Boolean active)   { this.active = active; }

    public Boolean getReceiver()               { return receiver; }
    public void    setReceiver(Boolean receiver){ this.receiver = receiver; }

    public String  getFileServerName()         { return fileServerName; }
    public void    setFileServerName(String fileServerName) { this.fileServerName = fileServerName; }

    public String  getFileServerIp()           { return fileServerIp; }
    public void    setFileServerIp(String fileServerIp)   { this.fileServerIp = fileServerIp; }

    public String  getFileServerUserId()       { return fileServerUserId; }
    public void    setFileServerUserId(String fileServerUserId){ this.fileServerUserId = fileServerUserId; }

    public String  getFileServerPassword()     { return fileServerPassword; }
    public void    setFileServerPassword(String fileServerPassword){ this.fileServerPassword = fileServerPassword; }

    public String  getFileName()               { return fileName; }
    public void    setFileName(String fileName)       { this.fileName = fileName; }

    public String  getUncShare()               { return uncShare; }
    public void    setUncShare(String uncShare)       { this.uncShare = uncShare; }

    public String  getPath()                   { return path; }
    public void    setPath(String path)           { this.path = path; }

    public String  getArchivePath()            { return archivePath; }
    public void    setArchivePath(String archivePath)    { this.archivePath = archivePath; }

    public String  getVendorTypeCode()         { return vendorTypeCode; }
    public void    setVendorTypeCode(String vendorTypeCode) { this.vendorTypeCode = vendorTypeCode; }

    public String  getFileIo()                 { return fileIo; }
    public void    setFileIo(String fileIo)         { this.fileIo = fileIo; }

    public Boolean getClientSpecific()         { return clientSpecific; }
    public void    setClientSpecific(Boolean clientSpecific){ this.clientSpecific = clientSpecific; }

    public String  getSchedule()               { return schedule; }
    public void    setSchedule(String schedule)       { this.schedule = schedule; }

    public String  getDateLastWorked()         { return dateLastWorked; }
    public void    setDateLastWorked(String dateLastWorked) { this.dateLastWorked = dateLastWorked; }

    public Integer getFileSize()               { return fileSize; }
    public void    setFileSize(Integer fileSize)      { this.fileSize = fileSize; }

    public String  getFileTransferSpecs()      { return fileTransferSpecs; }
    public void    setFileTransferSpecs(String fileTransferSpecs){ this.fileTransferSpecs = fileTransferSpecs; }

    public Integer getFileType()               { return fileType; }
    public void    setFileType(Integer fileType)      { this.fileType = fileType; }

    public String  getFtpPassive()             { return ftpPassive; }
    public void    setFtpPassive(String ftpPassive)     { this.ftpPassive = ftpPassive; }

    public String  getFtpFileType()            { return ftpFileType; }
    public void    setFtpFileType(String ftpFileType)    { this.ftpFileType = ftpFileType; }
}

