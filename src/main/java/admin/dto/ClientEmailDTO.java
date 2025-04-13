package admin.dto;

import java.time.LocalDateTime;

public class ClientEmailDTO {

    private Long id;
    private String clientId;
    private Long reportId;
    private String emailName;
    private String emailAddress;
    private Boolean carbonCopyFlag;
    private Boolean activeFlag;
    private Long mailServerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // --- Constructors ---
    public ClientEmailDTO() {
    }

    public ClientEmailDTO(Long id, String clientId, Long reportId, String emailName, String emailAddress,
                          Boolean carbonCopyFlag, Boolean activeFlag, Long mailServerId,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.clientId = clientId;
        this.reportId = reportId;
        this.emailName = emailName;
        this.emailAddress = emailAddress;
        this.carbonCopyFlag = carbonCopyFlag;
        this.activeFlag = activeFlag;
        this.mailServerId = mailServerId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

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
