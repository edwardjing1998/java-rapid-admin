package admin.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "FAILED_TRANS")
public class FailedTrans {

    @EmbeddedId
    private FailedTransId id;

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

    public FailedTransId getId() {
        return id;
    }

    public void setId(FailedTransId id) {
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
