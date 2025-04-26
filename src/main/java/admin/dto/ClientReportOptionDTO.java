package admin.dto;

public class ClientReportOptionDTO {
    private Long id;
    private String clientId;
    private Long reportId;
    private Boolean receiveFlag;
    private Integer outputTypeCd;
    private Integer fileTypeCd;
    private Integer emailFlag;
    private String reportPasswordTx;

    private String emailBodyTx;


    private AdminQueryListDTO reportDetails;  // ✅ New field


    public ClientReportOptionDTO(Long id, Long reportId, Boolean receiveFlag, Integer outputTypeCd, Integer fileTypeCd, Integer emailFlag, String reportPasswordTx, String emailBodyTx) {
        this.id = id;
        this.reportId = reportId;
        this.receiveFlag = receiveFlag;
        this.outputTypeCd = outputTypeCd;
        this.fileTypeCd = fileTypeCd;
        this.emailFlag = emailFlag;
        this.reportPasswordTx = reportPasswordTx;
        this.emailBodyTx = emailBodyTx;
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

    public Integer getOutputTypeCd() {
        return outputTypeCd;
    }

    public void setOutputTypeCd(Integer outputTypeCd) {
        this.outputTypeCd = outputTypeCd;
    }

    public Integer getFileTypeCd() {
        return fileTypeCd;
    }

    public void setFileTypeCd(Integer fileTypeCd) {
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

    public String getEmailBodyTx() {
        return emailBodyTx;
    }

    public void setEmailBodyTx(String emailBodyTx) {
        this.emailBodyTx = emailBodyTx;
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