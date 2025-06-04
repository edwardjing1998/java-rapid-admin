package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Composite key for BulkCard, consisting of:
 *   - caseNumber (VARCHAR(12))
 *   - piId       (VARCHAR(16))
 *   - bulkPiId   (VARCHAR(16))
 *   - inDate     (TIMESTAMP)
 */
@Embeddable
public class BulkCardId implements Serializable {

    @Column(name = "case_number", length = 12, nullable = false)
    private String caseNumber;

    @Column(name = "PI_ID", length = 16, nullable = false)
    private String piId;

    @Column(name = "Bulk_PI_ID", length = 16, nullable = false)
    private String bulkPiId;

    @Column(name = "in_date", nullable = false)
    private LocalDateTime inDate;

    public BulkCardId() {
    }

    public BulkCardId(String caseNumber, String piId, String bulkPiId, LocalDateTime inDate) {
        this.caseNumber = caseNumber;
        this.piId       = piId;
        this.bulkPiId   = bulkPiId;
        this.inDate     = inDate;
    }

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

    public String getBulkPiId() {
        return bulkPiId;
    }

    public void setBulkPiId(String bulkPiId) {
        this.bulkPiId = bulkPiId;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BulkCardId)) return false;
        BulkCardId that = (BulkCardId) o;
        return Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(piId,       that.piId)       &&
                Objects.equals(bulkPiId,   that.bulkPiId)   &&
                Objects.equals(inDate,     that.inDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, piId, bulkPiId, inDate);
    }
}
