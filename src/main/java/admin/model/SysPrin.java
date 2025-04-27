package admin.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SYS_PRINS")
public class SysPrin {

    @EmbeddedId
    private SysPrinId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "client", insertable = false, updatable = false)
    private Client client;

    @Column(name = "CUST_TYPE") private Integer custType;

    @Column(name = "UNDELIVERABLE") private String undeliverable;

    @Column(name = "STAT_A") private String statA;
    @Column(name = "STAT_B") private String statB;
    @Column(name = "STAT_C") private String statC;
    @Column(name = "STAT_D") private String statD;
    @Column(name = "STAT_E") private String statE;
    @Column(name = "STAT_F") private String statF;
    @Column(name = "STAT_I") private String statI;
    @Column(name = "STAT_L") private String statL;
    @Column(name = "STAT_O") private String statO;
    @Column(name = "STAT_U") private String statU;
    @Column(name = "STAT_X") private String statX;
    @Column(name = "STAT_Z") private String statZ;

    @Column(name = "PO_BOX") private String poBox;
    @Column(name = "ADDR_FLAG") private String addrFlag;
    @Column(name = "TEMP_AWAY") private Long tempAway;
    @Column(name = "RPS") private String rps;
    @Column(name = "SESSION") private String session;
    @Column(name = "BAD_STATE") private String badState;
    @Column(name = "A_STAT_RCH") private String aStatRch;
    @Column(name = "NM_13") private String nm13;
    @Column(name = "TEMP_AWAY_ATTS") private Long tempAwayAtts;
    @Column(name = "REPORT_METHOD") private Double reportMethod;
    @Column(name = "ACTIVE") private Boolean active;
    @Column(name = "NOTES") private String notes;
    @Column(name = "RET_STAT") private String returnStatus;
    @Column(name = "DES_STAT") private String destroyStatus;
    @Column(name = "NON_US") private String nonUS;

    @Column(name = "SPECIAL") private String special;
    @Column(name = "PIN") private String pinMailer;

    @Column(name = "FORWARDING_ADDR") private String forwardingAddress;

    @Column(name = "HOLD_DAYS") private Integer holdDays;

    @Column(name = "CONTACT") private String contact;

    @Column(name = "PHONE") private String phone;

    @Column(name = "ENTITY_CD") private String entityCode;

    // Getters and setters
    public SysPrinId getId() { return id; }
    public void setId(SysPrinId id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Integer getCustType() { return custType; }
    public void setCustType(Integer custType) { this.custType = custType; }

    public String getUndeliverable() { return undeliverable; }
    public void setUndeliverable(String undeliverable) { this.undeliverable = undeliverable; }

    public String getStatA() { return statA; }
    public void setStatA(String statA) { this.statA = statA; }
    public String getStatB() { return statB; }
    public void setStatB(String statB) { this.statB = statB; }
    public String getStatC() { return statC; }
    public void setStatC(String statC) { this.statC = statC; }
    public String getStatD() { return statD; }
    public void setStatD(String statD) { this.statD = statD; }
    public String getStatE() { return statE; }
    public void setStatE(String statE) { this.statE = statE; }
    public String getStatF() { return statF; }
    public void setStatF(String statF) { this.statF = statF; }
    public String getStatI() { return statI; }
    public void setStatI(String statI) { this.statI = statI; }
    public String getStatL() { return statL; }
    public void setStatL(String statL) { this.statL = statL; }
    public String getStatO() { return statO; }
    public void setStatO(String statO) { this.statO = statO; }
    public String getStatU() { return statU; }
    public void setStatU(String statU) { this.statU = statU; }
    public String getStatX() { return statX; }
    public void setStatX(String statX) { this.statX = statX; }
    public String getStatZ() { return statZ; }
    public void setStatZ(String statZ) { this.statZ = statZ; }

    public String getPoBox() { return poBox; }
    public void setPoBox(String poBox) { this.poBox = poBox; }
    public String getAddrFlag() { return addrFlag; }
    public void setAddrFlag(String addrFlag) { this.addrFlag = addrFlag; }
    public Long getTempAway() { return tempAway; }
    public void setTempAway(Long tempAway) { this.tempAway = tempAway; }
    public String getRps() { return rps; }
    public void setRps(String rps) { this.rps = rps; }
    public String getSession() { return session; }
    public void setSession(String session) { this.session = session; }
    public String getBadState() { return badState; }
    public void setBadState(String badState) { this.badState = badState; }
    public String getAStatRch() { return aStatRch; }
    public void setAStatRch(String aStatRch) { this.aStatRch = aStatRch; }
    public String getNm13() { return nm13; }
    public void setNm13(String nm13) { this.nm13 = nm13; }
    public Long getTempAwayAtts() { return tempAwayAtts; }
    public void setTempAwayAtts(Long tempAwayAtts) { this.tempAwayAtts = tempAwayAtts; }
    public Double getReportMethod() { return reportMethod; }
    public void setReportMethod(Double reportMethod) { this.reportMethod = reportMethod; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getReturnStatus() { return returnStatus; }
    public void setReturnStatus(String returnStatus) { this.returnStatus = returnStatus; }
    public String getDestroyStatus() { return destroyStatus; }
    public void setDestroyStatus(String destroyStatus) { this.destroyStatus = destroyStatus; }

    public String getSpecial() { return special; }
    public void setSpecial(String special) { this.special = special; }

    public Integer getHoldDays() { return holdDays; }
    public void setHoldDays(Integer holdDays) { this.holdDays = holdDays; }

    public String getPinMailer() { return pinMailer; }
    public void setPinMailer(String pinMailer) { this.pinMailer = pinMailer; }
    public String getNonUS() { return nonUS; }
    public void setNonUS(String nonUS) { this.nonUS = nonUS; }

    public String getForwardingAddress() { return forwardingAddress; }
    public void setForwardingAddress(String forwardingAddress) { this.forwardingAddress = forwardingAddress; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEntityCode() { return entityCode; }
    public void setEntityCode(String entityCode) { this.entityCode = entityCode; }

}