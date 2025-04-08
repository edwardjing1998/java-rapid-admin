package admin.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @Column(name = "client", nullable = false, length = 255)
    private String client;  // Primary key

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "addr", length = 255)
    private String addr;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "zip", length = 20)
    private String zip;

    @Column(name = "contact", length = 100)
    private String contact;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClientReportOption> reportOptions = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SysPrinsPrefix> sysPrinsPrefixes = new ArrayList<>();

    // Constructors
    public Client() {}

    public Client(String client, String name, String addr, String city, String state, String zip,
                  String contact, String phone, Boolean active,
                  List<ClientReportOption> reportOptions, List<SysPrinsPrefix> sysPrinsPrefixes) {
        this.client = client;
        this.name = name;
        this.addr = addr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.contact = contact;
        this.phone = phone;
        this.active = active;
        this.reportOptions = reportOptions != null ? reportOptions : new ArrayList<>();
        this.sysPrinsPrefixes = sysPrinsPrefixes != null ? sysPrinsPrefixes : new ArrayList<>();
    }

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

    // equals and hashCode based on 'client' primary key

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

    // Optional: toString

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

