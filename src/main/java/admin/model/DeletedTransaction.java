package admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DELETED_TRANSACTIONS")
public class DeletedTransaction {

    @EmbeddedId
    private DeletedTransactionId id;

    @Column(name = "type")
    private Short type;

    @Column(name = "command_line", length = 255)
    private String commandLine;

    @Column(name = "system_type", length = 50)
    private String systemType;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "cycle", length = 1)
    private String cycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "case_number", referencedColumnName = "case_number", insertable = false, updatable = false),
            @JoinColumn(name = "trans_no", referencedColumnName = "trans_no", insertable = false, updatable = false),
            @JoinColumn(name = "date_time", referencedColumnName = "date_time", insertable = false, updatable = false)
    })
    private DeletedAccountTransaction deletedTransaction;

    public DeletedAccountTransaction getDeletedTransaction() {
        return deletedTransaction;
    }

    public void setDeletedTransaction(DeletedAccountTransaction deletedTransaction) {
        this.deletedTransaction = deletedTransaction;
    }

    public DeletedTransactionId getId() {
        return id;
    }

    public void setId(DeletedTransactionId id) {
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

    public Integer getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
