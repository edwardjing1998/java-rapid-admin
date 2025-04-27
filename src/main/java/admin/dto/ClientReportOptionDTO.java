package admin.dto;

public class ClientReportOptionDTO {

    private String clientId;          // 🔥 From EmbeddedId
    private Integer reportId;          // 🔥 From EmbeddedId
    private Boolean receiveFlag;
    private Integer outputTypeCd;
    private Integer fileTypeCd;
    private Integer emailFlag;
    private String reportPasswordTx;

    private String emailBodyTx;


    private AdminQueryListDTO reportDetails;  // ✅ New field


    public ClientReportOptionDTO(String clientId,
                                 Integer reportId,
                                 Boolean receiveFlag,
                                 Integer outputTypeCd,
                                 Integer fileTypeCd,
                                 Integer emailFlag,
                                 String reportPasswordTx,
                                 String emailBodyTx) {
        this.clientId = clientId;
        this.reportId = reportId;
        this.receiveFlag = receiveFlag;
        this.outputTypeCd = outputTypeCd;
        this.fileTypeCd = fileTypeCd;
        this.emailFlag = emailFlag;
        this.reportPasswordTx = reportPasswordTx;
        this.emailBodyTx = emailBodyTx;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
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