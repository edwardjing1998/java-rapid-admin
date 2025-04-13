package admin.dto;

public class ClientReportOptionDTO {
    private Long id;
    private String clientId;
    private Long reportId;
    private Boolean receiveFlag;
    private String outputTypeCd;
    private String fileTypeCd;
    private Integer emailFlag;
    private String reportPasswordTx;

    private AdminQueryListDTO reportDetails;  // ✅ New field


    public ClientReportOptionDTO(Long id, Long reportId, Boolean receiveFlag, String outputTypeCd, String fileTypeCd, Integer emailFlag, String reportPasswordTx) {
        this.id = id;
        this.reportId = reportId;
        this.receiveFlag = receiveFlag;
        this.outputTypeCd = outputTypeCd;
        this.fileTypeCd = fileTypeCd;
        this.emailFlag = emailFlag;
        this.reportPasswordTx = reportPasswordTx;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Boolean getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(Boolean receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getOutputTypeCd() {
        return outputTypeCd;
    }

    public void setOutputTypeCd(String outputTypeCd) {
        this.outputTypeCd = outputTypeCd;
    }

    public String getFileTypeCd() {
        return fileTypeCd;
    }

    public void setFileTypeCd(String fileTypeCd) {
        this.fileTypeCd = fileTypeCd;
    }

    public Integer getEmailFlag() {
        return emailFlag;
    }

    public void setEmailFlag(Integer emailFlag) {
        this.emailFlag = emailFlag;
    }

    public String getReportPasswordTx() {
        return reportPasswordTx;
    }

    public void setReportPasswordTx(String reportPasswordTx) {
        this.reportPasswordTx = reportPasswordTx;
    }

    public AdminQueryListDTO getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(AdminQueryListDTO reportDetails) {
        this.reportDetails = reportDetails;
    }

    @Override
    public String toString() {
        return "ClientReportOptionDTO{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", reportId=" + reportId +
                ", receiveFlag=" + receiveFlag +
                ", outputTypeCd=" + outputTypeCd +
                ", fileTypeCd=" + fileTypeCd +
                ", emailFlag=" + emailFlag +
                ", reportPasswordTx='" + reportPasswordTx + '\'' +
                '}';
    }
}