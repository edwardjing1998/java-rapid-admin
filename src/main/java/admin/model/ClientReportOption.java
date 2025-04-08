package admin.model;

import jakarta.persistence.*;
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
    private Integer outputTypeCd;

    @Column(name = "FILE_TYPE_CD", nullable = false)
    private Integer fileTypeCd;

    @Column(name = "EMAIL_FLAG", nullable = false)
    private Integer emailFlag;

    @Column(name = "REPORT_PASSWORD_TX")
    private String reportPasswordTx;

    public ClientReportOption() {
    }

    public ClientReportOption(Long id, Client client, Long reportId, Boolean receiveFlag, Integer outputTypeCd, Integer fileTypeCd, Integer emailFlag, String reportPasswordTx) {
        this.id = id;
        this.client = client;
        this.reportId = reportId;
        this.receiveFlag = receiveFlag;
        this.outputTypeCd = outputTypeCd;
        this.fileTypeCd = fileTypeCd;
        this.emailFlag = emailFlag;
        this.reportPasswordTx = reportPasswordTx;
    }

    // Getters and Setters

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

    public Integer getOutputTypeCd() {
        return outputTypeCd;
    }

    public void setOutputTypeCd(Integer outputTypeCd) {
        this.outputTypeCd = outputTypeCd;
    }

    public Integer getFileTypeCd() {
        return fileTypeCd;
    }

    public void setFileTypeCd(Integer fileTypeCd) {
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

    // toString

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

    // equals & hashCode (optional but recommended for JPA entities)

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
}