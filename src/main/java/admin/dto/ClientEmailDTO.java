package admin.dto;

public class ClientEmailDTO {

    private String clientId;
    private String emailAddressTx;
    private Long reportId;
    private String emailNameTx;
    private Boolean carbonCopyFlag;
    private Boolean activeFlag;
    private Long mailServerId;

    public ClientEmailDTO() {
    }

    public ClientEmailDTO(String clientId, String emailAddressTx, Long reportId, String emailNameTx, Boolean carbonCopyFlag, Boolean activeFlag, Long mailServerId) {
        this.clientId = clientId;
        this.emailAddressTx = emailAddressTx;
        this.reportId = reportId;
        this.emailNameTx = emailNameTx;
        this.carbonCopyFlag = carbonCopyFlag;
        this.activeFlag = activeFlag;
        this.mailServerId = mailServerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmailAddressTx() {
        return emailAddressTx;
    }

    public void setEmailAddressTx(String emailAddressTx) {
        this.emailAddressTx = emailAddressTx;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getEmailNameTx() {
        return emailNameTx;
    }

    public void setEmailNameTx(String emailNameTx) {
        this.emailNameTx = emailNameTx;
    }

    public Boolean getCarbonCopyFlag() {
        return carbonCopyFlag;
    }

    public void setCarbonCopyFlag(Boolean carbonCopyFlag) {
        this.carbonCopyFlag = carbonCopyFlag;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Long getMailServerId() {
        return mailServerId;
    }

    public void setMailServerId(Long mailServerId) {
        this.mailServerId = mailServerId;
    }
}
