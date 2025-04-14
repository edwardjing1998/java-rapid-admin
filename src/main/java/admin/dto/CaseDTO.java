package admin.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CaseDTO {

    private String caseNumber;
    private String account;
    private String lastName;
    private String firstName;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String zip;
    private String homePhone;
    private String workPhone;
    private String status;
    private Integer numCards;
    private LocalDate nextDate;
    private Boolean noRenewal;
    private String reason;
    private String disposition;
    private LocalDate inDate;
    private String deliveryId;
    private String sysPrin;
    private LocalDate outDate;
    private String cycle;
    private Boolean active;
    private LocalTime inHour;
    private LocalDate autoDate;
    private String subreason;
    private String client;
    private String prodType;

    public CaseDTO() {
    }

    private CaseDTO(Builder builder) {
        this.caseNumber = builder.caseNumber;
        this.account = builder.account;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.addr1 = builder.addr1;
        this.addr2 = builder.addr2;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
        this.homePhone = builder.homePhone;
        this.workPhone = builder.workPhone;
        this.status = builder.status;
        this.numCards = builder.numCards;
        this.nextDate = builder.nextDate;
        this.noRenewal = builder.noRenewal;
        this.reason = builder.reason;
        this.disposition = builder.disposition;
        this.inDate = builder.inDate;
        this.deliveryId = builder.deliveryId;
        this.sysPrin = builder.sysPrin;
        this.outDate = builder.outDate;
        this.cycle = builder.cycle;
        this.active = builder.active;
        this.inHour = builder.inHour;
        this.autoDate = builder.autoDate;
        this.subreason = builder.subreason;
        this.client = builder.client;
        this.prodType = builder.prodType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String caseNumber;
        private String account;
        private String lastName;
        private String firstName;
        private String addr1;
        private String addr2;
        private String city;
        private String state;
        private String zip;
        private String homePhone;
        private String workPhone;
        private String status;
        private Integer numCards;
        private LocalDate nextDate;
        private Boolean noRenewal;
        private String reason;
        private String disposition;
        private LocalDate inDate;
        private String deliveryId;
        private String sysPrin;
        private LocalDate outDate;
        private String cycle;
        private Boolean active;
        private LocalTime inHour;
        private LocalDate autoDate;
        private String subreason;
        private String client;
        private String prodType;

        public Builder caseNumber(String caseNumber) { this.caseNumber = caseNumber; return this; }
        public Builder account(String account) { this.account = account; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder addr1(String addr1) { this.addr1 = addr1; return this; }
        public Builder addr2(String addr2) { this.addr2 = addr2; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder zip(String zip) { this.zip = zip; return this; }
        public Builder homePhone(String homePhone) { this.homePhone = homePhone; return this; }
        public Builder workPhone(String workPhone) { this.workPhone = workPhone; return this; }
        public Builder status(String status) { this.status = status; return this; }
        public Builder numCards(Integer numCards) { this.numCards = numCards; return this; }
        public Builder nextDate(LocalDate nextDate) { this.nextDate = nextDate; return this; }
        public Builder noRenewal(Boolean noRenewal) { this.noRenewal = noRenewal; return this; }
        public Builder reason(String reason) { this.reason = reason; return this; }
        public Builder disposition(String disposition) { this.disposition = disposition; return this; }
        public Builder inDate(LocalDate inDate) { this.inDate = inDate; return this; }
        public Builder deliveryId(String deliveryId) { this.deliveryId = deliveryId; return this; }
        public Builder sysPrin(String sysPrin) { this.sysPrin = sysPrin; return this; }
        public Builder outDate(LocalDate outDate) { this.outDate = outDate; return this; }
        public Builder cycle(String cycle) { this.cycle = cycle; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }
        public Builder inHour(LocalTime inHour) { this.inHour = inHour; return this; }
        public Builder autoDate(LocalDate autoDate) { this.autoDate = autoDate; return this; }
        public Builder subreason(String subreason) { this.subreason = subreason; return this; }
        public Builder client(String client) { this.client = client; return this; }
        public Builder prodType(String prodType) { this.prodType = prodType; return this; }

        public CaseDTO build() {
            return new CaseDTO(this);
        }
    }

    // All getters and setters

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

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getProdType() { return prodType; }
    public void setProdType(String prodType) { this.prodType = prodType; }
}

