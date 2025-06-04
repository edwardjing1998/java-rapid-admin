package admin.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FailedTransactionDTO {
    private String caseNumber;
    private BigDecimal transNo;
    private Short type;
    private String commandLine;
    private String systemType;
    private Short retryCount;
    private LocalDateTime dateTime;
    private String cycle;

    public FailedTransactionDTO() {
    }

    public FailedTransactionDTO(String caseNumber, BigDecimal transNo, Short type, String commandLine,
                                String systemType, Short retryCount, LocalDateTime dateTime, String cycle) {
        this.caseNumber = caseNumber;
        this.transNo = transNo;
        this.type = type;
        this.commandLine = commandLine;
        this.systemType = systemType;
        this.retryCount = retryCount;
        this.dateTime = dateTime;
        this.cycle = cycle;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public BigDecimal getTransNo() {
        return transNo;
    }

    public void setTransNo(BigDecimal transNo) {
        this.transNo = transNo;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getSystemType() {
        return systemType;
    }

    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    public Short getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Short retryCount) {
        this.retryCount = retryCount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
