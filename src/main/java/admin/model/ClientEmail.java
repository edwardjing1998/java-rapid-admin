package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client_email")
public class ClientEmail {

    @EmbeddedId
    private ClientEmailId id;

    @Column(name = "Report_ID", nullable = false)
    private Long reportId;

    @Column(name = "Email_Name_tx", nullable = false)
    private String emailNameTx;

    @Column(name = "Carbon_Copy_Flag", nullable = false)
    private Boolean carbonCopyFlag;

    @Column(name = "Active_Flag", nullable = false)
    private Boolean activeFlag;

    @Column(name = "Mail_Server_ID", nullable = false)
    private Long mailServerId;

    public ClientEmail() {
    }

    public ClientEmail(ClientEmailId id, Long reportId, String emailNameTx, Boolean carbonCopyFlag, Boolean activeFlag, Long mailServerId) {
        this.id = id;
        this.reportId = reportId;
        this.emailNameTx = emailNameTx;
        this.carbonCopyFlag = carbonCopyFlag;
        this.activeFlag = activeFlag;
        this.mailServerId = mailServerId;
    }

    public ClientEmailId getId() {
        return id;
    }

    public void setId(ClientEmailId id) {
        this.id = id;
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
