package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientReportOptionId implements Serializable {

    @Column(name = "client_id", length = 15)
    private String clientId;

    @Column(name = "report_id")
    private Integer reportId;

    public ClientReportOptionId() {
    }

    public ClientReportOptionId(String clientId, Integer reportId) {
        this.clientId = clientId;
        this.reportId = reportId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientReportOptionId)) return false;
        ClientReportOptionId that = (ClientReportOptionId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(reportId, that.reportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, reportId);
    }
}
