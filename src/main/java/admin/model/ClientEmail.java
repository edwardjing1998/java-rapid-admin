package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "client_email")
public class ClientEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Client_ID", nullable = false)
    private String clientId;

    @Column(name = "Report_ID", nullable = false)
    private Long reportId;

    @Column(name = "Email_Name_tx", nullable = false)
    private String emailName;

    @Column(name = "Email_Address_tx", nullable = false)
    private String emailAddress;

    @Column(name = "Carbon_Copy_Flag", nullable = false)
    private Boolean carbonCopyFlag;

    @Column(name = "Active_Flag", nullable = false)
    private Boolean activeFlag;

    @Column(name = "Mail_Server_ID", nullable = false)
    private Long mailServerId;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // --- Constructors ---
    public ClientEmail() {}

    // --- Getters and Setters ---

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

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
