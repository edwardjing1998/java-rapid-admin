package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "robot_labels")
public class RobotLabels {

    @EmbeddedId
    private RobotLabelsId id;

    @Column(name = "bundles")
    private Integer bundles;

    @Column(name = "individual_labels")
    private Integer individualLabels;

    @Column(name = "robot_label_total")
    private Integer robotLabelTotal;

    // Getters and Setters
    public RobotLabelsId getId() { return id; }
    public void setId(RobotLabelsId id) { this.id = id; }

    public Integer getBundles() { return bundles; }
    public void setBundles(Integer bundles) { this.bundles = bundles; }

    public Integer getIndividualLabels() { return individualLabels; }
    public void setIndividualLabels(Integer individualLabels) { this.individualLabels = individualLabels; }

    public Integer getRobotLabelTotal() { return robotLabelTotal; }
    public void setRobotLabelTotal(Integer robotLabelTotal) { this.robotLabelTotal = robotLabelTotal; }
}

