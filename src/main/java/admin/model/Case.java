package admin.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "CASES")
public class Case {

    @Id
    @Column(name = "case_number")
    private String caseNumber;

    private String account;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String zip;

    @Column(name = "hm_phone")
    private String homePhone;

    @Column(name = "wk_phone")
    private String workPhone;

    private String status;

    @Column(name = "num_cards")
    private Integer numCards;

    @Column(name = "next_date")
    private LocalDate nextDate;

    @Column(name = "no_renewal")
    private Boolean noRenewal;

    private String reason;
    private String disposition;

    @Column(name = "in_date")
    private LocalDate inDate;

    @Column(name = "delivery_id")
    private String deliveryId;

    @Column(name = "sys_prin")
    private String sysPrin;

    @Column(name = "out_date")
    private LocalDate outDate;

    private String cycle;
    private Boolean active;

    @Column(name = "in_hour")
    private LocalTime inHour;

    @Column(name = "auto_date")
    private LocalDate autoDate;

    private String subreason;

    @Column(name = "prod_type")
    private String prodType;

    public Case() {}

    public Case(String caseNumber, String account, String lastName, String firstName,
                String addr1, String addr2, String city, String state, String zip,
                String homePhone, String workPhone, String status, Integer numCards,
                LocalDate nextDate, Boolean noRenewal, String reason, String disposition,
                LocalDate inDate, String deliveryId, String sysPrin, LocalDate outDate,
                String cycle, Boolean active, LocalTime inHour, LocalDate autoDate,
                String subreason, String prodType) {
        this.caseNumber = caseNumber;
        this.account = account;
        this.lastName = lastName;
        this.firstName = firstName;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.status = status;
        this.numCards = numCards;
        this.nextDate = nextDate;
        this.noRenewal = noRenewal;
        this.reason = reason;
        this.disposition = disposition;
        this.inDate = inDate;
        this.deliveryId = deliveryId;
        this.sysPrin = sysPrin;
        this.outDate = outDate;
        this.cycle = cycle;
        this.active = active;
        this.inHour = inHour;
        this.autoDate = autoDate;
        this.subreason = subreason;
        this.prodType = prodType;
    }

    // Getters and Setters...

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getAddr1() { return addr1; }
    public void setAddr1(String addr1) { this.addr1 = addr1; }

    public String getAddr2() { return addr2; }
    public void setAddr2(String addr2) { this.addr2 = addr2; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getHomePhone() { return homePhone; }
    public void setHomePhone(String homePhone) { this.homePhone = homePhone; }

    public String getWorkPhone() { return workPhone; }
    public void setWorkPhone(String workPhone) { this.workPhone = workPhone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getNumCards() { return numCards; }
    public void setNumCards(Integer numCards) { this.numCards = numCards; }

    public LocalDate getNextDate() { return nextDate; }
    public void setNextDate(LocalDate nextDate) { this.nextDate = nextDate; }

    public Boolean getNoRenewal() { return noRenewal; }
    public void setNoRenewal(Boolean noRenewal) { this.noRenewal = noRenewal; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getDisposition() { return disposition; }
    public void setDisposition(String disposition) { this.disposition = disposition; }

    public LocalDate getInDate() { return inDate; }
    public void setInDate(LocalDate inDate) { this.inDate = inDate; }

    public String getDeliveryId() { return deliveryId; }
    public void setDeliveryId(String deliveryId) { this.deliveryId = deliveryId; }

    public String getSysPrin() { return sysPrin; }
    public void setSysPrin(String sysPrin) { this.sysPrin = sysPrin; }

    public LocalDate getOutDate() { return outDate; }
    public void setOutDate(LocalDate outDate) { this.outDate = outDate; }

    public String getCycle() { return cycle; }
    public void setCycle(String cycle) { this.cycle = cycle; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalTime getInHour() { return inHour; }
    public void setInHour(LocalTime inHour) { this.inHour = inHour; }

    public LocalDate getAutoDate() { return autoDate; }
    public void setAutoDate(LocalDate autoDate) { this.autoDate = autoDate; }

    public String getSubreason() { return subreason; }
    public void setSubreason(String subreason) { this.subreason = subreason; }

    public String getProdType() { return prodType; }
    public void setProdType(String prodType) { this.prodType = prodType; }
}
