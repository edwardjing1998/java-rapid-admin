package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class RobotLabelsId implements Serializable {

    @Column(name = "user_name", length = 25)
    private String userName;

    @Column(name = "reporting_date")
    private LocalDateTime reportingDate;

    public RobotLabelsId() {}

    public RobotLabelsId(String userName, LocalDateTime reportingDate) {
        this.userName = userName;
        this.reportingDate = reportingDate;
    }

    // Getters and Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public LocalDateTime getReportingDate() { return reportingDate; }
    public void setReportingDate(LocalDateTime reportingDate) { this.reportingDate = reportingDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RobotLabelsId)) return false;
        RobotLabelsId that = (RobotLabelsId) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(reportingDate, that.reportingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, reportingDate);
    }
}
