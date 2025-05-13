package admin.dto;

import java.time.LocalDateTime;

public class FailedTransWorkDTO {

    private String caseNumber;
    private String piId;
    private String account;
    private LocalDateTime dateTime;
    private Integer nonMon;
    private Integer retryCount;
    private String message;

    public FailedTransWorkDTO() {}

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getNonMon() {
        return nonMon;
    }

    public void setNonMon(Integer nonMon) {
        this.nonMon = nonMon;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
