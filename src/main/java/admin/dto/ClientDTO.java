package admin.dto;

import admin.model.ClientReportOption;
import admin.model.SysPrinsPrefix;

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

    private List<ClientReportOption> reportOptions;
    private List<SysPrinsPrefix> sysPrinsPrefixes;

    // Getters and Setters
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ClientReportOption> getReportOptions() {
        return reportOptions;
    }

    public void setReportOptions(List<ClientReportOption> reportOptions) {
        this.reportOptions = reportOptions;
    }

    public List<SysPrinsPrefix> getSysPrinsPrefixes() {
        return sysPrinsPrefixes;
    }

    public void setSysPrinsPrefixes(List<SysPrinsPrefix> sysPrinsPrefixes) {
        this.sysPrinsPrefixes = sysPrinsPrefixes;
    }

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
                ", active=" + active +
                '}';
    }
}
