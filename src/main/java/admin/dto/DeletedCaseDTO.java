package admin.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DeletedCaseDTO {
    private String caseNumber;
    private String piId;
    private String customerId;
    private String primaryPiId;
    private String account;
    private String lastName;
    private String firstName;
    private String hmPhone;
    private String wkPhone;
    private String entityCd;
    private String roleCd;

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPrimaryPiId() {
        return primaryPiId;
    }

    public void setPrimaryPiId(String primaryPiId) {
        this.primaryPiId = primaryPiId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHmPhone() {
        return hmPhone;
    }

    public void setHmPhone(String hmPhone) {
        this.hmPhone = hmPhone;
    }

    public String getWkPhone() {
        return wkPhone;
    }

    public void setWkPhone(String wkPhone) {
        this.wkPhone = wkPhone;
    }

    public String getEntityCd() {
        return entityCd;
    }

    public void setEntityCd(String entityCd) {
        this.entityCd = entityCd;
    }

    public String getRoleCd() {
        return roleCd;
    }

    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    public String getPiStatus() {
        return piStatus;
    }

    public void setPiStatus(String piStatus) {
        this.piStatus = piStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getSubreason() {
        return subreason;
    }

    public void setSubreason(Integer subreason) {
        this.subreason = subreason;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public Integer getInHour() {
        return inHour;
    }

    public void setInHour(Integer inHour) {
        this.inHour = inHour;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    public LocalDateTime getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDateTime nextDate) {
        this.nextDate = nextDate;
    }

    public LocalDateTime getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDateTime outDate) {
        this.outDate = outDate;
    }

    public LocalDateTime getAutoDate() {
        return autoDate;
    }

    public void setAutoDate(LocalDateTime autoDate) {
        this.autoDate = autoDate;
    }

    public Integer getNumCards() {
        return numCards;
    }

    public void setNumCards(Integer numCards) {
        this.numCards = numCards;
    }

    public Integer getFinalActionCardsNr() {
        return finalActionCardsNr;
    }

    public void setFinalActionCardsNr(Integer finalActionCardsNr) {
        this.finalActionCardsNr = finalActionCardsNr;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getFrstUpdtVendId() {
        return frstUpdtVendId;
    }

    public void setFrstUpdtVendId(String frstUpdtVendId) {
        this.frstUpdtVendId = frstUpdtVendId;
    }

    public String getContactCd() {
        return contactCd;
    }

    public void setContactCd(String contactCd) {
        this.contactCd = contactCd;
    }

    public String getContactPhNr() {
        return contactPhNr;
    }

    public void setContactPhNr(String contactPhNr) {
        this.contactPhNr = contactPhNr;
    }

    public String getReturnReasonCd() {
        return returnReasonCd;
    }

    public void setReturnReasonCd(String returnReasonCd) {
        this.returnReasonCd = returnReasonCd;
    }

    public String getIssuanceCd() {
        return issuanceCd;
    }

    public void setIssuanceCd(String issuanceCd) {
        this.issuanceCd = issuanceCd;
    }

    public LocalDateTime getIssuanceDt() {
        return issuanceDt;
    }

    public void setIssuanceDt(LocalDateTime issuanceDt) {
        this.issuanceDt = issuanceDt;
    }

    public String getWorkStationNameTx() {
        return workStationNameTx;
    }

    public void setWorkStationNameTx(String workStationNameTx) {
        this.workStationNameTx = workStationNameTx;
    }

    public String getOperatorCd() {
        return operatorCd;
    }

    public void setOperatorCd(String operatorCd) {
        this.operatorCd = operatorCd;
    }

    public String getBarcodeTypeCd() {
        return barcodeTypeCd;
    }

    public void setBarcodeTypeCd(String barcodeTypeCd) {
        this.barcodeTypeCd = barcodeTypeCd;
    }

    public String getRecTypTx() {
        return recTypTx;
    }

    public void setRecTypTx(String recTypTx) {
        this.recTypTx = recTypTx;
    }

    public String getSrvcTypTx() {
        return srvcTypTx;
    }

    public void setSrvcTypTx(String srvcTypTx) {
        this.srvcTypTx = srvcTypTx;
    }

    public String getMailerId() {
        return mailerId;
    }

    public void setMailerId(String mailerId) {
        this.mailerId = mailerId;
    }

    public String getAs400ClientId() {
        return as400ClientId;
    }

    public void setAs400ClientId(String as400ClientId) {
        this.as400ClientId = as400ClientId;
    }

    public String getAs400SystemId() {
        return as400SystemId;
    }

    public void setAs400SystemId(String as400SystemId) {
        this.as400SystemId = as400SystemId;
    }

    public String getBscSpplmntlId() {
        return bscSpplmntlId;
    }

    public void setBscSpplmntlId(String bscSpplmntlId) {
        this.bscSpplmntlId = bscSpplmntlId;
    }

    public LocalDateTime getOrigMlDt() {
        return origMlDt;
    }

    public void setOrigMlDt(LocalDateTime origMlDt) {
        this.origMlDt = origMlDt;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMlMthd() {
        return mlMthd;
    }

    public void setMlMthd(String mlMthd) {
        this.mlMthd = mlMthd;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getCustId() {
        return custId;
    }

    public void getCustomerId(String custId) {
        this.custId = custId;
    }

    public String getMsIssueDate() {
        return msIssueDate;
    }

    public void setMsIssueDate(String msIssueDate) {
        this.msIssueDate = msIssueDate;
    }

    public String getCustomerId2() {
        return custId2;
    }

    public void setCustomerId2(String custId2) {
        this.custId2 = custId2;
    }

    public String getMarketCode() {
        return mktCd;
    }

    public void setMarketCode(String mktCd) {
        this.mktCd = mktCd;
    }

    public String getAccountTokenid() {
        return accountTokenid;
    }

    public void setAccountTokenid(String accountTokenid) {
        this.accountTokenid = accountTokenid;
    }

    public String getPiIdTokenId() {
        return piIdTokenid;
    }

    public void setPiIdTokenId(String piIdTokenid) {
        this.piIdTokenid = piIdTokenid;
    }

    public String getPrimaryPiIdTokenId() {
        return primaryPiIdTokenid;
    }

    public void setPrimaryPiIdTokenId(String primaryPiIdTokenid) {
        this.primaryPiIdTokenid = primaryPiIdTokenid;
    }

    public List<DeletedAccountTransactionDTO> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<DeletedAccountTransactionDTO> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    private String piStatus;
    private String status;
    private boolean active;
    private String reason;
    private Integer subreason;
    private String disposition;
    private Integer inHour;
    private LocalDateTime inDate;
    private LocalDateTime nextDate;
    private LocalDateTime outDate;
    private LocalDateTime autoDate;
    private Integer numCards;
    private Integer finalActionCardsNr;
    private Integer deliveryId;
    private String sysPrin;
    private String cycle;
    private String frstUpdtVendId;
    private String contactCd;
    private String contactPhNr;
    private String returnReasonCd;
    private String issuanceCd;
    private LocalDateTime issuanceDt;
    private String workStationNameTx;
    private String operatorCd;
    private String barcodeTypeCd;
    private String recTypTx;
    private String srvcTypTx;
    private String mailerId;
    private String as400ClientId;
    private String as400SystemId;
    private String bscSpplmntlId;
    private LocalDateTime origMlDt;
    private String msgId;
    private String mlMthd;
    private String sourceFile;
    private String custId;
    private String msIssueDate;
    private String custId2;
    private String mktCd;
    private String accountTokenid;
    private String piIdTokenid;
    private String primaryPiIdTokenid;

    // New field: List of associated transactions
    private List<DeletedAccountTransactionDTO> accountTransactions;

    public DeletedCaseDTO(String caseNumber, String piId, String customerId, String primaryPiId, String account, String lastName, String firstName, String hmPhone, String wkPhone, String entityCd, String roleCd, String piStatus, String status, boolean active, String reason, Integer subreason, String disposition, Integer inHour, LocalDateTime inDate, LocalDateTime nextDate, LocalDateTime outDate, LocalDateTime autoDate, Integer numCards, Integer finalActionCardsNr, Integer deliveryId, String sysPrin, String cycle, String frstUpdtVendId, String contactCd, String contactPhNr, String returnReasonCd, String issuanceCd, LocalDateTime issuanceDt, String workStationNameTx, String operatorCd, String barcodeTypeCd, String recTypTx, String srvcTypTx, String mailerId, String as400ClientId, String as400SystemId, String bscSpplmntlId, LocalDateTime origMlDt, String msgId, String mlMthd, String sourceFile, String custId, String msIssueDate, String custId2, String mktCd, String accountTokenid, String piIdTokenid, String primaryPiIdTokenid) {
        this.caseNumber = caseNumber;
        this.piId = piId;
        this.customerId = customerId;
        this.primaryPiId = primaryPiId;
        this.account = account;
        this.lastName = lastName;
        this.firstName = firstName;
        this.hmPhone = hmPhone;
        this.wkPhone = wkPhone;
        this.entityCd = entityCd;
        this.roleCd = roleCd;
        this.piStatus = piStatus;
        this.status = status;
        this.active = active;
        this.reason = reason;
        this.subreason = subreason;
        this.disposition = disposition;
        this.inHour = inHour;
        this.inDate = inDate;
        this.nextDate = nextDate;
        this.outDate = outDate;
        this.autoDate = autoDate;
        this.numCards = numCards;
        this.finalActionCardsNr = finalActionCardsNr;
        this.deliveryId = deliveryId;
        this.sysPrin = sysPrin;
        this.cycle = cycle;
        this.frstUpdtVendId = frstUpdtVendId;
        this.contactCd = contactCd;
        this.contactPhNr = contactPhNr;
        this.returnReasonCd = returnReasonCd;
        this.issuanceCd = issuanceCd;
        this.issuanceDt = issuanceDt;
        this.workStationNameTx = workStationNameTx;
        this.operatorCd = operatorCd;
        this.barcodeTypeCd = barcodeTypeCd;
        this.recTypTx = recTypTx;
        this.srvcTypTx = srvcTypTx;
        this.mailerId = mailerId;
        this.as400ClientId = as400ClientId;
        this.as400SystemId = as400SystemId;
        this.bscSpplmntlId = bscSpplmntlId;
        this.origMlDt = origMlDt;
        this.msgId = msgId;
        this.mlMthd = mlMthd;
        this.sourceFile = sourceFile;
        this.custId = custId;
        this.msIssueDate = msIssueDate;
        this.custId2 = custId2;
        this.mktCd = mktCd;
        this.accountTokenid = accountTokenid;
        this.piIdTokenid = piIdTokenid;
        this.primaryPiIdTokenid = primaryPiIdTokenid;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public DeletedCaseDTO() {}


}
