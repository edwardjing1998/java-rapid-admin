package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "labels")
public class Labels {

    @EmbeddedId
    private LabelsId id;

    // Getters and Setters for the id
    public LabelsId getId() { return id; }
    public void setId(LabelsId id) { this.id = id; }
}
