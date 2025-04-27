package admin.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "contact")
    private String contact;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "billing_sp")
    private String billingSp;

    @Column(name = "report_break_flag")
    private Integer reportBreakFlag;

    @Column(name = "chlookup_type")
    private Integer chLookUpType;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "exclude_from_report")
    private Boolean excludeFromReport;

    @Column(name = "positive_reports")
    private Boolean positiveReports;

    @Column(name = "sub_client_ind")
    private Boolean subClientInd;

    @Column(name = "sub_client_xref")
    private String subClientXref;

    @Column(name = "amex_issued")
    private Boolean amexIssued;

    @OneToMany(mappedBy = "id.clientId", cascade = CascadeType.ALL)
    private List<ClientReportOption> reportOptions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "billing_sp", referencedColumnName = "client")
    private List<SysPrinsPrefix> sysPrinsPrefixes = new ArrayList<>();


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SysPrin> sysPrins = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Client_ID", referencedColumnName = "client")
    private List<ClientEmail> clientEmails = new ArrayList<>();

    public Client() {}

    public Client(String client, String name, String addr, String city, String state, String zip,
                  String contact, String phone, Boolean active, String faxNumber, String billingSp,
                  Integer reportBreakFlag, Integer chLookUpType, Boolean excludeFromReport, Boolean positiveReports,
                  Integer subClientInd, String subClientXref, Boolean amexIssued,
                  List<ClientReportOption> reportOptions, List<SysPrinsPrefix> sysPrinsPrefixes,
                  List<SysPrin> sysPrins, List<ClientEmail> clientEmails) {
        this.client = client;
        this.name = name;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contact = contact;
        this.phone = phone;
        this.active = active;
        this.faxNumber = faxNumber;
        this.billingSp = billingSp;
        this.reportBreakFlag = reportBreakFlag;
        this.chLookUpType = chLookUpType;
        this.excludeFromReport = excludeFromReport;
        this.positiveReports = positiveReports;
        this.subClientInd = subClientInd != null && subClientInd != 0;
        this.subClientXref = subClientXref;
        this.amexIssued = amexIssued;
        this.reportOptions = reportOptions != null ? reportOptions : new ArrayList<>();
        this.sysPrinsPrefixes = sysPrinsPrefixes != null ? sysPrinsPrefixes : new ArrayList<>();
        this.sysPrins = sysPrins != null ? sysPrins : new ArrayList<>();
        this.clientEmails = clientEmails != null ? clientEmails : new ArrayList<>();
    }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddr() { return addr; }
    public void setAddr(String addr) { this.addr = addr; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFaxNumber() { return faxNumber; }
    public void setFaxNumber(String faxNumber) { this.faxNumber = faxNumber; }

    public String getBillingSp() { return billingSp; }
    public void setBillingSp(String billingSp) { this.billingSp = billingSp; }

    public Integer getReportBreakFlag() { return reportBreakFlag; }
    public void setReportBreakFlag(Integer reportBreakFlag) { this.reportBreakFlag = reportBreakFlag; }

    public Integer getChLookUpType() { return chLookUpType; }
    public void setChLookUpType(Integer chLookUpType) { this.chLookUpType = chLookUpType; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Boolean getExcludeFromReport() { return excludeFromReport; }
    public void setExcludeFromReport(Boolean excludeFromReport) { this.excludeFromReport = excludeFromReport; }

    public Boolean getPositiveReports() { return positiveReports; }
    public void setPositiveReports(Boolean positiveReports) { this.positiveReports = positiveReports; }

    public Boolean getSubClientInd() { return subClientInd; }
    public void setSubClientInd(Boolean subClientInd) { this.subClientInd = subClientInd; }

    public String getSubClientXref() { return subClientXref; }
    public void setSubClientXref(String subClientXref) { this.subClientXref = subClientXref; }

    public Boolean getAmexIssued() { return amexIssued; }
    public void setAmexIssued(Boolean amexIssued) { this.amexIssued = amexIssued; }

    public List<ClientReportOption> getReportOptions() { return reportOptions; }
    public void setReportOptions(List<ClientReportOption> reportOptions) { this.reportOptions = reportOptions; }

    public List<SysPrinsPrefix> getSysPrinsPrefixes() { return sysPrinsPrefixes; }
    public void setSysPrinsPrefixes(List<SysPrinsPrefix> sysPrinsPrefixes) { this.sysPrinsPrefixes = sysPrinsPrefixes; }

    public List<SysPrin> getSysPrins() { return sysPrins; }
    public void setSysPrins(List<SysPrin> sysPrins) { this.sysPrins = sysPrins; }

    public List<ClientEmail> getClientEmails() { return clientEmails; }
    public void setClientEmails(List<ClientEmail> clientEmails) { this.clientEmails = clientEmails; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client1 = (Client) o;
        return Objects.equals(client, client1.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client);
    }

    @Override
    public String toString() {
        return "Client{" +
                "client='" + client + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }
}
