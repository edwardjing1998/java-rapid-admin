package admin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "failed_trans")
public class FailedTransaction {

    @EmbeddedId
    private FailedTransactionId id;

    @Column(name = "type")
    private Short type;

    @Column(name = "command_line", length = 255)
    private String commandLine;

    @Column(name = "system_type", length = 50)
    private String systemType;

    @Column(name = "retry_count")
    private Short retryCount;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "cycle", length = 1)
    private String cycle;

    @MapsId("caseNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_number", nullable = false)
    private Case caseEntity;

    public FailedTransaction() {
    }

    public FailedTransactionId getId() {
        return id;
    }

    public void setId(FailedTransactionId id) {
        this.id = id;
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

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}

