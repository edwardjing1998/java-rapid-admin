package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class FailedTransactionId implements Serializable {

    @Column(name = "case_number", length = 12)
    private String caseNumber;

    @Column(name = "trans_no")
    private BigDecimal transNo;

    public FailedTransactionId() {
    }

    public FailedTransactionId(String caseNumber, BigDecimal transNo) {
        this.caseNumber = caseNumber;
        this.transNo = transNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FailedTransactionId that = (FailedTransactionId) o;
        return Objects.equals(caseNumber, that.caseNumber)
                && Objects.equals(transNo, that.transNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, transNo);
    }
}

