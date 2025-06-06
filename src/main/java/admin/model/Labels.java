package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "labels")
public class Labels {

    @EmbeddedId
    private LabelsId id;

    @MapsId("caseNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_number", nullable = false)
    private Case caseEntity;

    // Getters and Setters for the id
    public LabelsId getId() { return id; }
    public void setId(LabelsId id) { this.id = id; }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}
