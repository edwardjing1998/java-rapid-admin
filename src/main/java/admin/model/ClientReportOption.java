package admin.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "CLIENT_REPORT_OPTIONS")
public class ClientReportOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @Column(name = "REPORT_ID", nullable = false)
    private Long reportId;

    @Column(name = "RECEIVE_FLAG", nullable = false)
    private Boolean receiveFlag;

    @Column(name = "OUTPUT_TYPE_CD", nullable = false)
    private String outputTypeCd;

    @Column(name = "FILE_TYPE_CD", nullable = false)
    private String fileTypeCd;

    @Column(name = "EMAIL_FLAG", nullable = false)
    private Integer emailFlag;

    @Column(name = "REPORT_PASSWORD_TX")
    private String reportPasswordTx;

    // ✅ New association with AdminQueryList

    @ManyToOne
    @JoinColumn(name = "REPORT_ID", referencedColumnName = "report_id", insertable = false, updatable = false)
    @Where(clause = "report_by_client_flag = 1")
    private AdminQueryList report;

    public ClientReportOption() {}

    public ClientReportOption(Long id, Client client, Long reportId, Boolean receiveFlag,
                              String outputTypeCd, String fileTypeCd, Integer emailFlag,
                              String reportPasswordTx) {
        this.id = id;
        this.client = client;
        this.reportId = reportId;
        this.receiveFlag = receiveFlag;
        this.outputTypeCd = outputTypeCd;
        this.fileTypeCd = fileTypeCd;
        this.emailFlag = emailFlag;
        this.reportPasswordTx = reportPasswordTx;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Boolean getReceiveFlag() {
        return receiveFlag;
    }

    public void setReceiveFlag(Boolean receiveFlag) {
        this.receiveFlag = receiveFlag;
    }

    public String getOutputTypeCd() {
        return outputTypeCd;
    }

    public void setOutputTypeCd(String outputTypeCd) {
        this.outputTypeCd = outputTypeCd;
    }

    public String getFileTypeCd() {
        return fileTypeCd;
    }

    public void setFileTypeCd(String fileTypeCd) {
        this.fileTypeCd = fileTypeCd;
    }

    public Integer getEmailFlag() {
        return emailFlag;
    }

    public void setEmailFlag(Integer emailFlag) {
        this.emailFlag = emailFlag;
    }

    public String getReportPasswordTx() {
        return reportPasswordTx;
    }

    public void setReportPasswordTx(String reportPasswordTx) {
        this.reportPasswordTx = reportPasswordTx;
    }

    public AdminQueryList getReport() {
        return report;
    }

    public void setReport(AdminQueryList report) {
        this.report = report;
    }

    // equals, hashCode, and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientReportOption)) return false;
        ClientReportOption that = (ClientReportOption) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClientReportOption{" +
                "id=" + id +
                ", reportId=" + reportId +
                ", receiveFlag=" + receiveFlag +
                ", outputTypeCd=" + outputTypeCd +
                ", fileTypeCd=" + fileTypeCd +
                ", emailFlag=" + emailFlag +
                ", reportPasswordTx='" + reportPasswordTx + '\'' +
                '}';
    }
}
