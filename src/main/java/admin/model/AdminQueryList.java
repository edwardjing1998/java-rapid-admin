package admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ADMIN_QUERY_LIST")
public class AdminQueryList {

    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @Column(name = "query_name", nullable = false, length = 50)
    private String queryName;

    @Column(name = "query", columnDefinition = "TEXT")
    private String query;

    @Column(name = "input_data_fields", nullable = false, length = 255)
    private String inputDataFields;

    @Column(name = "file_ext", nullable = false, length = 3)
    private String fileExt;

    @Column(name = "db_driver_type", nullable = false, length = 30)
    private String dbDriverType;

    @Column(name = "file_header_ind", nullable = false)
    private Integer fileHeaderInd;

    @Column(name = "default_file_nm", nullable = false, length = 100)
    private String defaultFileNm;

    @Column(name = "report_db_server", nullable = false, length = 100)
    private String reportDbServer;

    @Column(name = "report_db", nullable = false, length = 100)
    private String reportDb;

    @Column(name = "report_db_userid", nullable = false, length = 50)
    private String reportDbUserid;

    @Column(name = "report_db_passwrd", nullable = false, length = 100)
    private String reportDbPasswrd;

    @Column(name = "file_transfer_type")
    private Integer fileTransferType;

    @Column(name = "report_db_ip_and_port", nullable = false, length = 100)
    private String reportDbIpAndPort;

    @Column(name = "report_by_client_flag")
    private Boolean reportByClientFlag;

    @Column(name = "rerun_date_range_start")
    private LocalDateTime rerunDateRangeStart;

    @Column(name = "rerun_date_range_end")
    private LocalDateTime rerunDateRangeEnd;

    @Column(name = "rerun_client_id", length = 4)
    private String rerunClientId;

    @Column(name = "email_from_address", length = 50)
    private String emailFromAddress;

    @Column(name = "email_event_id", length = 50)
    private String emailEventId;

    @Column(name = "tab_delimited_flag")
    private Boolean tabDelimitedFlag;

    @Column(name = "input_file_tx", length = 100)
    private String inputFileTx;

    @Column(name = "input_file_key_start_pos")
    private Integer inputFileKeyStartPos;

    @Column(name = "input_file_key_length")
    private Integer inputFileKeyLength;

    @Column(name = "access_level")
    private Byte accessLevel;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "num_sheets")
    private Integer numSheets;

    @OneToOne(mappedBy = "adminQueryList", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private C3FileTransfer c3FileTransfer;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ClientReportOption> clientReportOptions = new ArrayList<>();

    public AdminQueryList() {

    }

    public List<ClientReportOption>  getClientReportOptions() {
        return clientReportOptions;
    }

    public void setClientReportOptions(List<ClientReportOption> clientReportOptions) {
        this.clientReportOptions = clientReportOptions;
    }

    // ------ Getter and Setter Methods ------
    public C3FileTransfer getC3FileTransfer() {
        return c3FileTransfer;
    }

    public void setC3FileTransfer(C3FileTransfer c3FileTransfer) {
        this.c3FileTransfer = c3FileTransfer;
    }

    public Integer getReportId() {
        return reportId;
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

    @Override
    public String toString() {
        return "AdminQueryList{" +
                "reportId=" + reportId +
                ", queryName='" + queryName + '\'' +
                ", query='" + query + '\'' +
                ", inputDataFields='" + inputDataFields + '\'' +
                ", fileExt='" + fileExt + '\'' +
                ", dbDriverType='" + dbDriverType + '\'' +
                ", fileHeaderInd=" + fileHeaderInd +
                ", defaultFileNm='" + defaultFileNm + '\'' +
                ", reportDbServer='" + reportDbServer + '\'' +
                ", reportDb='" + reportDb + '\'' +
                ", reportDbUserid='" + reportDbUserid + '\'' +
                ", reportDbPasswrd='[PROTECTED]'" + // mask password
                ", fileTransferType=" + fileTransferType +
                ", reportDbIpAndPort='" + reportDbIpAndPort + '\'' +
                ", reportByClientFlag=" + reportByClientFlag +
                ", rerunDateRangeStart=" + rerunDateRangeStart +
                ", rerunDateRangeEnd=" + rerunDateRangeEnd +
                ", rerunClientId='" + rerunClientId + '\'' +
                ", emailFromAddress='" + emailFromAddress + '\'' +
                ", emailEventId='" + emailEventId + '\'' +
                ", tabDelimitedFlag=" + tabDelimitedFlag +
                ", inputFileTx='" + inputFileTx + '\'' +
                ", inputFileKeyStartPos=" + inputFileKeyStartPos +
                ", inputFileKeyLength=" + inputFileKeyLength +
                ", accessLevel=" + accessLevel +
                ", isActive=" + isActive +
                ", isVisible=" + isVisible +
                ", numSheets=" + numSheets +
                '}';
    }
}
