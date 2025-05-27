package admin.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class TransactionId implements Serializable {

    private String caseNumber;
    private BigDecimal transNo;
    private LocalDateTime dateTime;

    // Getters, Setters, equals() and hashCode()

    // Constructors
    public TransactionId() {}

    public TransactionId(String caseNumber, BigDecimal transNo, LocalDateTime dateTime) {
        this.caseNumber = caseNumber;
        this.transNo = transNo;
        this.dateTime = dateTime;
    }

    // Getters and setters

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public BigDecimal getTransNo() { return transNo; }
    public void setTransNo(BigDecimal transNo) { this.transNo = transNo; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionId that)) return false;
        return Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(transNo, that.transNo) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, transNo, dateTime);
    }
}
