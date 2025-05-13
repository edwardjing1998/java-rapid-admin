package admin.dto;

import java.time.LocalDateTime;

public class FailedTransSummaryDTO {

    public FailedTransSummaryDTO(String caseNumber, String piId, LocalDateTime dateTime,
                                 String account, String message, Integer retryCount, String nonMon) {
        this.caseNumber = caseNumber;
        this.piId = piId;
        this.dateTime = dateTime;
        this.account = account;
        this.message = message;
        this.retryCount = retryCount;
        this.nonMon = nonMon;
    }
    private String caseNumber;
    private String piId;
    private LocalDateTime dateTime;
    private String account;
    private String message;
    private Integer retryCount;

    private String nonMon;

    // Getters and setters
    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getPiId() { return piId; }
    public void setPiId(String piId) { this.piId = piId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Integer getRetryCount() { return retryCount; }
    public void setRetryCount(Integer retryCount) { this.retryCount = retryCount; }

    public String getNonMon() { return nonMon; }
    public void setNonMon(String nonMon) { this.nonMon = nonMon; }
}
