package admin.model;

import jakarta.persistence.*;


@Entity
@Table(name = "bulk_card")
public class BulkCard {

    @EmbeddedId
    private BulkCardId id;

    @MapsId("caseNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_number", nullable = false)
    private Case caseEntity;

    public BulkCard() {
    }

    public BulkCard(BulkCardId id) {
        this.id = id;
    }

    public BulkCardId getId() {
        return id;
    }

    public void setId(BulkCardId id) {
        this.id = id;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}
