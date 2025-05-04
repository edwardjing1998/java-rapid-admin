package admin.dto;

import java.util.List;

public class ClientDTO {
    private String client;
    private String name;
    private String addr;
    private String city;
    private String state;
    private String zip;
    private String contact;
    private String phone;
    private Boolean active;

    // Additional fields
    private String faxNumber;
    private String billingSp;
    private Integer reportBreakFlag;
    private Integer chLookUpType;
    private Boolean excludeFromReport;
    private Boolean positiveReports;
    private Boolean subClientInd;
    private String subClientXref;
    private Boolean amexIssued;

    private List<ClientReportOptionDTO> reportOptions;
    private List<SysPrinsPrefixDTO> sysPrinsPrefixes;
    private List<ClientEmailDTO> clientEmail;
    private List<SysPrinDTO> sysPrins;

    // Getters and Setters
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

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getFaxNumber() { return faxNumber; }
    public void setFaxNumber(String faxNumber) { this.faxNumber = faxNumber; }

    public String getBillingSp() { return billingSp; }
    public void setBillingSp(String billingSp) { this.billingSp = billingSp; }

    public Integer getReportBreakFlag() { return reportBreakFlag; }
    public void setReportBreakFlag(Integer reportBreakFlag) { this.reportBreakFlag = reportBreakFlag; }

    public Integer getChLookUpType() { return chLookUpType; }
    public void setChLookUpType(Integer chLookUpType) { this.chLookUpType = chLookUpType; }

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

    public List<ClientReportOptionDTO> getReportOptions() { return reportOptions; }
    public void setReportOptions(List<ClientReportOptionDTO> reportOptions) { this.reportOptions = reportOptions; }

    public List<SysPrinsPrefixDTO> getSysPrinsPrefixes() { return sysPrinsPrefixes; }
    public void setSysPrinsPrefixes(List<SysPrinsPrefixDTO> sysPrinsPrefixes) { this.sysPrinsPrefixes = sysPrinsPrefixes; }

    public List<SysPrinDTO> getSysPrins() { return sysPrins; }
    public void setSysPrins(List<SysPrinDTO> sysPrins) { this.sysPrins = sysPrins; }

    public List<ClientEmailDTO> getClientEmail() { return clientEmail; }
    public void setClientEmail(List<ClientEmailDTO> clientEmail) { this.clientEmail = clientEmail; }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "client='" + client + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", billingSp='" + billingSp + '\'' +
                ", reportBreakFlag=" + reportBreakFlag +
                ", chLookUpType=" + chLookUpType +
                ", excludeFromReport=" + excludeFromReport +
                ", positiveReports=" + positiveReports +
                ", subClientInd=" + subClientInd +
                ", subClientXref='" + subClientXref + '\'' +
                ", amexIssued=" + amexIssued +
                ", active=" + active +
                '}';
    }
}
