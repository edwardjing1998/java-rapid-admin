package admin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class AccountTransactionId implements Serializable {

    private String caseNumber;
    private BigDecimal transNo;
    private LocalDateTime dateTime;

    public AccountTransactionId() {}

    public AccountTransactionId(String caseNumber, BigDecimal transNo, LocalDateTime dateTime) {
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
        if (!(o instanceof AccountTransactionId)) return false;
        AccountTransactionId that = (AccountTransactionId) o;
        return Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(transNo, that.transNo) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, transNo, dateTime);
    }
}

