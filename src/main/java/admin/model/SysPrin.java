package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SYS_PRINS")
public class SysPrin {

    @EmbeddedId
    private SysPrinId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "client", insertable = false, updatable = false)
    private Client client;

    @Column(name = "CUST_TYPE") private String custType;
    @Column(name = "START_DATE") private String startDate;
    @Column(name = "UNDELIVERABLE") private String undeliverable;

    @Column(name = "STAT_A") private String statA;
    @Column(name = "STAT_B") private String statB;
    @Column(name = "STAT_C") private String statC;
    @Column(name = "STAT_D") private String statD;
    @Column(name = "STAT_E") private String statE;
    @Column(name = "STAT_F") private String statF;
    @Column(name = "STAT_G") private String statG;
    @Column(name = "STAT_H") private String statH;
    @Column(name = "STAT_I") private String statI;
    @Column(name = "STAT_J") private String statJ;
    @Column(name = "STAT_K") private String statK;
    @Column(name = "STAT_L") private String statL;
    @Column(name = "STAT_M") private String statM;
    @Column(name = "STAT_N") private String statN;
    @Column(name = "STAT_O") private String statO;
    @Column(name = "STAT_P") private String statP;
    @Column(name = "STAT_Q") private String statQ;
    @Column(name = "STAT_R") private String statR;
    @Column(name = "STAT_S") private String statS;
    @Column(name = "STAT_T") private String statT;
    @Column(name = "STAT_U") private String statU;
    @Column(name = "STAT_V") private String statV;
    @Column(name = "STAT_W") private String statW;
    @Column(name = "STAT_X") private String statX;
    @Column(name = "STAT_Y") private String statY;
    @Column(name = "STAT_Z") private String statZ;

    @Column(name = "PO_BOX") private String poBox;
    @Column(name = "NO_RENEWAL") private String noRenewal;
    @Column(name = "BLOCK_CARD") private String blockCard;
    @Column(name = "ADDR_FLAG") private String addrFlag;
    @Column(name = "TEMP_AWAY") private Long tempAway;
    @Column(name = "RSP") private String rsp;
    @Column(name = "SESSION") private String session;
    @Column(name = "BAD_STATE") private String badState;
    @Column(name = "A_STAT_RCH") private String aStatRch;
    @Column(name = "NM_13") private String nm13;
    @Column(name = "TEMP_AWAY_ATTS") private Long tempAwayAtts;
    @Column(name = "REPORT_METHOD") private String reportMethod;
    @Column(name = "CONTACT") private String contact;
    @Column(name = "PHONE") private String phone;
    @Column(name = "ACTIVE") private String active;
    @Column(name = "NOTES") private String notes;
    @Column(name = "RET_STAT") private String returnStatus;
    @Column(name = "DES_STAT") private String destroyStatus;
    @Column(name = "NON_US") private String nonUS;

    // Getters and setters
    public SysPrinId getId() { return id; }
    public void setId(SysPrinId id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public String getCustType() { return custType; }
    public void setCustType(String custType) { this.custType = custType; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

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
    public String getStatG() { return statG; }
    public void setStatG(String statG) { this.statG = statG; }
    public String getStatH() { return statH; }
    public void setStatH(String statH) { this.statH = statH; }
    public String getStatI() { return statI; }
    public void setStatI(String statI) { this.statI = statI; }
    public String getStatJ() { return statJ; }
    public void setStatJ(String statJ) { this.statJ = statJ; }
    public String getStatK() { return statK; }
    public void setStatK(String statK) { this.statK = statK; }
    public String getStatL() { return statL; }
    public void setStatL(String statL) { this.statL = statL; }
    public String getStatM() { return statM; }
    public void setStatM(String statM) { this.statM = statM; }
    public String getStatN() { return statN; }
    public void setStatN(String statN) { this.statN = statN; }
    public String getStatO() { return statO; }
    public void setStatO(String statO) { this.statO = statO; }
    public String getStatP() { return statP; }
    public void setStatP(String statP) { this.statP = statP; }
    public String getStatQ() { return statQ; }
    public void setStatQ(String statQ) { this.statQ = statQ; }
    public String getStatR() { return statR; }
    public void setStatR(String statR) { this.statR = statR; }
    public String getStatS() { return statS; }
    public void setStatS(String statS) { this.statS = statS; }
    public String getStatT() { return statT; }
    public void setStatT(String statT) { this.statT = statT; }
    public String getStatU() { return statU; }
    public void setStatU(String statU) { this.statU = statU; }
    public String getStatV() { return statV; }
    public void setStatV(String statV) { this.statV = statV; }
    public String getStatW() { return statW; }
    public void setStatW(String statW) { this.statW = statW; }
    public String getStatX() { return statX; }
    public void setStatX(String statX) { this.statX = statX; }
    public String getStatY() { return statY; }
    public void setStatY(String statY) { this.statY = statY; }
    public String getStatZ() { return statZ; }
    public void setStatZ(String statZ) { this.statZ = statZ; }

    public String getPoBox() { return poBox; }
    public void setPoBox(String poBox) { this.poBox = poBox; }
    public String getNoRenewal() { return noRenewal; }
    public void setNoRenewal(String noRenewal) { this.noRenewal = noRenewal; }
    public String getBlockCard() { return blockCard; }
    public void setBlockCard(String blockCard) { this.blockCard = blockCard; }
    public String getAddrFlag() { return addrFlag; }
    public void setAddrFlag(String addrFlag) { this.addrFlag = addrFlag; }
    public Long getTempAway() { return tempAway; }
    public void setTempAway(Long tempAway) { this.tempAway = tempAway; }
    public String getRsp() { return rsp; }
    public void setRsp(String rsp) { this.rsp = rsp; }
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
    public String getReportMethod() { return reportMethod; }
    public void setReportMethod(String reportMethod) { this.reportMethod = reportMethod; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getActive() { return active; }
    public void setActive(String active) { this.active = active; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getReturnStatus() { return returnStatus; }
    public void setReturnStatus(String returnStatus) { this.returnStatus = returnStatus; }
    public String getDestroyStatus() { return destroyStatus; }
    public void setDestroyStatus(String destroyStatus) { this.destroyStatus = destroyStatus; }
    public String getNonUS() { return nonUS; }
    public void setNonUS(String nonUS) { this.nonUS = nonUS; }
}