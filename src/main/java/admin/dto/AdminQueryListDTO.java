package admin.dto;

import java.time.LocalDateTime;

public class AdminQueryListDTO {
    private Long reportId;
    private String reportName;
    private Integer reportByClientFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Integer getReportByClientFlag() {
        return reportByClientFlag;
    }

    public void setReportByClientFlag(Integer reportByClientFlag) {
        this.reportByClientFlag = reportByClientFlag;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
