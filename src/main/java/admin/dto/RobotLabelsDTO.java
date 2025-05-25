package admin.dto;

import java.time.LocalDateTime;

public class RobotLabelsDTO {
    private String userName;
    private LocalDateTime reportingDate;
    private Integer bundles;
    private Integer individualLabels;
    private Integer robotLabelTotal;

    public RobotLabelsDTO() {}

    public RobotLabelsDTO(String userName, LocalDateTime reportingDate, Integer bundles, Integer individualLabels, Integer robotLabelTotal) {
        this.userName = userName;
        this.reportingDate = reportingDate;
        this.bundles = bundles;
        this.individualLabels = individualLabels;
        this.robotLabelTotal = robotLabelTotal;
    }

    // Getters and Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public LocalDateTime getReportingDate() { return reportingDate; }
    public void setReportingDate(LocalDateTime reportingDate) { this.reportingDate = reportingDate; }

    public Integer getBundles() { return bundles; }
    public void setBundles(Integer bundles) { this.bundles = bundles; }

    public Integer getIndividualLabels() { return individualLabels; }
    public void setIndividualLabels(Integer individualLabels) { this.individualLabels = individualLabels; }

    public Integer getRobotLabelTotal() { return robotLabelTotal; }
    public void setRobotLabelTotal(Integer robotLabelTotal) { this.robotLabelTotal = robotLabelTotal; }
}
