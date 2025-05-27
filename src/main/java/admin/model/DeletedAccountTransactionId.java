package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class DeletedAccountTransactionId implements Serializable {
    @Column(name = "case_number", insertable = false, updatable = false)
    private String caseNumber;
    @Column(name = "trans_no", nullable=false)
    private BigDecimal transNo;
    @Column(name = "date_time", nullable=false)
    private LocalDateTime dateTime;

    public DeletedAccountTransactionId() {}

    public DeletedAccountTransactionId(String caseNumber, BigDecimal transNo, LocalDateTime dateTime) {
        this.caseNumber = caseNumber;
        this.transNo = transNo;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeletedAccountTransactionId)) return false;
        DeletedAccountTransactionId that = (DeletedAccountTransactionId) o;
        return Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(transNo, that.transNo) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, transNo, dateTime);
    }
}

