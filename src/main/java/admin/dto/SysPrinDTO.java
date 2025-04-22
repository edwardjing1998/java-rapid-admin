package admin.dto;

import java.util.List;

public class SysPrinDTO {
    private String client;
    private String sysPrin;

    private String custType;
    private String undeliverable;

    private String statA, statB, statC, statD, statE, statF, statI;
    private String statL, statO;
    private String statU, statX, statZ;

    private String poBox;
    private String addrFlag;
    private Long tempAway;
    private String rps;
    private String session;
    private String badState;
    private String aStatRch;
    private String nm13;
    private Long tempAwayAtts;
    private String reportMethod;
    private String active;
    private String notes;
    private String returnStatus;
    private String destroyStatus;
    private String nonUS;
    private String special;
    private String pinMailer;
    private Integer holdDays;

    private String forwardingAddress;

    private List<InvalidDelivAreaDTO> invalidDelivAreas;

    // Getters and Setters

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getSysPrin() { return sysPrin; }
    public void setSysPrin(String sysPrin) { this.sysPrin = sysPrin; }

    public String getCustType() { return custType; }
    public void setCustType(String custType) { this.custType = custType; }

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
    public String getReportMethod() { return reportMethod; }
    public void setReportMethod(String reportMethod) { this.reportMethod = reportMethod; }
    public String getActive() { return active; }
    public void setActive(String active) { this.active = active; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public String getReturnStatus() { return returnStatus; }
    public void setReturnStatus(String returnStatus) { this.returnStatus = returnStatus; }
    public String getDestroyStatus() { return destroyStatus; }
    public void setDestroyStatus(String destroyStatus) { this.destroyStatus = destroyStatus; }
    public String getSpecial() { return special; }
    public void setSpecial(String special) { this.special = special; }
    public String getPinMailer() { return pinMailer; }
    public void setPinMailer(String pinMailer) { this.pinMailer = pinMailer; }
    public String getNonUS() { return nonUS; }
    public void setNonUS(String nonUS) { this.nonUS = nonUS; }

    public Integer getHoldDays() { return holdDays; }
    public void setHoldDays(Integer holdDays) { this.holdDays = holdDays; }

    public List<InvalidDelivAreaDTO> getInvalidDelivAreas() {
        return invalidDelivAreas;
    }

    public void setInvalidDelivAreas(List<InvalidDelivAreaDTO> invalidDelivAreas) {
        this.invalidDelivAreas = invalidDelivAreas;
    }

    public String getForwardingAddress() {
        return forwardingAddress;
    }

    public void setForwardingAddress(String forwardingAddress) {
        this.forwardingAddress = forwardingAddress;
    }

}
