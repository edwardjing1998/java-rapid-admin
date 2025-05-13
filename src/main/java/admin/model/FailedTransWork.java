package admin.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "FAILED_TRANS_WORK")
public class FailedTransWork {

    @EmbeddedId
    private FailedTransWorkId id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "non_mon")
    private Integer nonMon;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "message", length = 255)
    private String message;

    public FailedTransWork() {}

    public FailedTransWorkId getId() {
        return id;
    }

    public void setId(FailedTransWorkId id) {
        this.id = id;
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
