package admin.dto;

import admin.model.AdminQueryList;

import java.time.LocalDateTime;

public class AdminQueryListDTO {

    public AdminQueryListDTO(AdminQueryList entity) {
        this.reportId = entity.getReportId();
        this.queryName = entity.getQueryName();
        this.query = entity.getQuery();
        this.inputDataFields = entity.getInputDataFields();
        this.fileExt = entity.getFileExt();
        this.dbDriverType = entity.getDbDriverType();
        this.fileHeaderInd = entity.getFileHeaderInd();
        this.defaultFileNm = entity.getDefaultFileNm();
        this.reportDbServer = entity.getReportDbServer();
        this.reportDb = entity.getReportDb();
        this.reportDbUserid = entity.getReportDbUserid();
        this.reportDbPasswrd = entity.getReportDbPasswrd();
        this.fileTransferType = entity.getFileTransferType();
        this.reportDbIpAndPort = entity.getReportDbIpAndPort();
        this.reportByClientFlag = entity.getReportByClientFlag();
        this.rerunDateRangeStart = entity.getRerunDateRangeStart();
        this.rerunDateRangeEnd = entity.getRerunDateRangeEnd();
        this.rerunClientId = entity.getRerunClientId();
        this.emailFromAddress = entity.getEmailFromAddress();
        this.emailEventId = entity.getEmailEventId();
        this.tabDelimitedFlag = entity.getTabDelimitedFlag();
        this.inputFileTx = entity.getInputFileTx();
        this.inputFileKeyStartPos = entity.getInputFileKeyStartPos();
        this.inputFileKeyLength = entity.getInputFileKeyLength();
        this.accessLevel = entity.getAccessLevel();
        this.isActive = entity.getIsActive();
        this.isVisible = entity.getIsVisible();
        this.numSheets = entity.getNumSheets();
    }


    private Integer reportId;
    private String queryName;
    private String query;
    private String inputDataFields;
    private String fileExt;
    private String dbDriverType;
    private Integer fileHeaderInd;
    private String defaultFileNm;
    private String reportDbServer;
    private String reportDb;
    private String reportDbUserid;
    private String reportDbPasswrd;
    private Integer fileTransferType;
    private String reportDbIpAndPort;
    private Boolean reportByClientFlag;
    private LocalDateTime rerunDateRangeStart;
    private LocalDateTime rerunDateRangeEnd;
    private String rerunClientId;
    private String emailFromAddress;
    private String emailEventId;
    private Boolean tabDelimitedFlag;
    private String inputFileTx;
    private Integer inputFileKeyStartPos;
    private Integer inputFileKeyLength;
    private Byte accessLevel;
    private Boolean isActive;
    private Boolean isVisible;
    private Integer numSheets;

    public AdminQueryListDTO() {
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getInputDataFields() {
        return inputDataFields;
    }

    public void setInputDataFields(String inputDataFields) {
        this.inputDataFields = inputDataFields;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getDbDriverType() {
        return dbDriverType;
    }

    public void setDbDriverType(String dbDriverType) {
        this.dbDriverType = dbDriverType;
    }

    public Integer getFileHeaderInd() {
        return fileHeaderInd;
    }

    public void setFileHeaderInd(Integer fileHeaderInd) {
        this.fileHeaderInd = fileHeaderInd;
    }

    public String getDefaultFileNm() {
        return defaultFileNm;
    }

    public void setDefaultFileNm(String defaultFileNm) {
        this.defaultFileNm = defaultFileNm;
    }

    public String getReportDbServer() {
        return reportDbServer;
    }

    public void setReportDbServer(String reportDbServer) {
        this.reportDbServer = reportDbServer;
    }

    public String getReportDb() {
        return reportDb;
    }

    public void setReportDb(String reportDb) {
        this.reportDb = reportDb;
    }

    public String getReportDbUserid() {
        return reportDbUserid;
    }

    public void setReportDbUserid(String reportDbUserid) {
        this.reportDbUserid = reportDbUserid;
    }

    public String getReportDbPasswrd() {
        return reportDbPasswrd;
    }

    public void setReportDbPasswrd(String reportDbPasswrd) {
        this.reportDbPasswrd = reportDbPasswrd;
    }

    public Integer getFileTransferType() {
        return fileTransferType;
    }

    public void setFileTransferType(Integer fileTransferType) {
        this.fileTransferType = fileTransferType;
    }

    public String getReportDbIpAndPort() {
        return reportDbIpAndPort;
    }

    public void setReportDbIpAndPort(String reportDbIpAndPort) {
        this.reportDbIpAndPort = reportDbIpAndPort;
    }

    public Boolean getReportByClientFlag() {
        return reportByClientFlag;
    }

    public void setReportByClientFlag(Boolean reportByClientFlag) {
        this.reportByClientFlag = reportByClientFlag;
    }

    public LocalDateTime getRerunDateRangeStart() {
        return rerunDateRangeStart;
    }

    public void setRerunDateRangeStart(LocalDateTime rerunDateRangeStart) {
        this.rerunDateRangeStart = rerunDateRangeStart;
    }

    public LocalDateTime getRerunDateRangeEnd() {
        return rerunDateRangeEnd;
    }

    public void setRerunDateRangeEnd(LocalDateTime rerunDateRangeEnd) {
        this.rerunDateRangeEnd = rerunDateRangeEnd;
    }

    public String getRerunClientId() {
        return rerunClientId;
    }

    public void setRerunClientId(String rerunClientId) {
        this.rerunClientId = rerunClientId;
    }

    public String getEmailFromAddress() {
        return emailFromAddress;
    }

    public void setEmailFromAddress(String emailFromAddress) {
        this.emailFromAddress = emailFromAddress;
    }

    public String getEmailEventId() {
        return emailEventId;
    }

    public void setEmailEventId(String emailEventId) {
        this.emailEventId = emailEventId;
    }

    public Boolean getTabDelimitedFlag() {
        return tabDelimitedFlag;
    }

    public void setTabDelimitedFlag(Boolean tabDelimitedFlag) {
        this.tabDelimitedFlag = tabDelimitedFlag;
    }

    public String getInputFileTx() {
        return inputFileTx;
    }

    public void setInputFileTx(String inputFileTx) {
        this.inputFileTx = inputFileTx;
    }

    public Integer getInputFileKeyStartPos() {
        return inputFileKeyStartPos;
    }

    public void setInputFileKeyStartPos(Integer inputFileKeyStartPos) {
        this.inputFileKeyStartPos = inputFileKeyStartPos;
    }

    public Integer getInputFileKeyLength() {
        return inputFileKeyLength;
    }

    public void setInputFileKeyLength(Integer inputFileKeyLength) {
        this.inputFileKeyLength = inputFileKeyLength;
    }

    public Byte getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Byte accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Integer getNumSheets() {
        return numSheets;
    }

    public void setNumSheets(Integer numSheets) {
        this.numSheets = numSheets;
    }
}
