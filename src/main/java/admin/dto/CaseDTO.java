package admin.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CaseDTO {
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
    private String piStatus;
    private Character status;
    private Boolean active;
    private Character reason;
    private Integer subreason;
    private Character disposition;
    private Integer inHour;
    private LocalDateTime inDate;
    private LocalDateTime nextDate;
    private LocalDateTime outDate;
    private LocalDateTime autoDate;
    private Integer numCards;
    private Integer finalActionCardsNr;
    private Integer deliveryId;
    private String sysPrin;
    private Character cycle;
    private String frstUpdtVendId;
    private String contactCd;
    private String contactPhNr;
    private String returnReasonCd;
    private String issuanceCd;
    private LocalDateTime issuanceDt;
    private String workstationNameTx;
    private String operatorCd;
    private String barcodeTypeCd;
    private String fileSent;
    private String postageBilled;
    private Boolean issuedByAmex;
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

    private String client;

    private List<AccountTransactionDTO> accountTransactions;



    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }


    private CaseDTO(Builder builder) {
        this.caseNumber = builder.caseNumber;
        this.piId = builder.piId;
        this.customerId = builder.customerId;
        this.primaryPiId = builder.primaryPiId;
        this.account = builder.account;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.hmPhone = builder.hmPhone;
        this.wkPhone = builder.wkPhone;
        this.entityCd = builder.entityCd;
        this.roleCd = builder.roleCd;
        this.piStatus = builder.piStatus;
        this.status = builder.status;
        this.active = builder.active;
        this.reason = builder.reason;
        this.subreason = builder.subreason;
        this.disposition = builder.disposition;
        this.inHour = builder.inHour;
        this.inDate = builder.inDate;
        this.nextDate = builder.nextDate;
        this.outDate = builder.outDate;
        this.autoDate = builder.autoDate;
        this.numCards = builder.numCards;
        this.finalActionCardsNr = builder.finalActionCardsNr;
        this.deliveryId = builder.deliveryId;
        this.sysPrin = builder.sysPrin;
        this.cycle = builder.cycle;
        this.frstUpdtVendId = builder.frstUpdtVendId;
        this.contactCd = builder.contactCd;
        this.contactPhNr = builder.contactPhNr;
        this.returnReasonCd = builder.returnReasonCd;
        this.issuanceCd = builder.issuanceCd;
        this.issuanceDt = builder.issuanceDt;
        this.workstationNameTx = builder.workstationNameTx;
        this.operatorCd = builder.operatorCd;
        this.barcodeTypeCd = builder.barcodeTypeCd;
        this.fileSent = builder.fileSent;
        this.postageBilled = builder.postageBilled;
        this.issuedByAmex = builder.issuedByAmex;
        this.recTypTx = builder.recTypTx;
        this.srvcTypTx = builder.srvcTypTx;
        this.mailerId = builder.mailerId;
        this.as400ClientId = builder.as400ClientId;
        this.as400SystemId = builder.as400SystemId;
        this.bscSpplmntlId = builder.bscSpplmntlId;
        this.origMlDt = builder.origMlDt;
        this.msgId = builder.msgId;
        this.mlMthd = builder.mlMthd;
        this.sourceFile = builder.sourceFile;
        this.custId = builder.custId;
        this.msIssueDate = builder.msIssueDate;
        this.custId2 = builder.custId2;
        this.mktCd = builder.mktCd;
        this.accountTokenid = builder.accountTokenid;
        this.piIdTokenid = builder.piIdTokenid;
        this.primaryPiIdTokenid = builder.primaryPiIdTokenid;
        this.client = builder.client;
        this.accountTransactions = builder.accountTransactions; // ✅ add this line
    }

    public static class Builder {
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
        private String piStatus;
        private Character status;
        private Boolean active;
        private Character reason;
        private Integer subreason;
        private Character disposition;
        private Integer inHour;
        private LocalDateTime inDate;
        private LocalDateTime nextDate;
        private LocalDateTime outDate;
        private LocalDateTime autoDate;
        private Integer numCards;
        private Integer finalActionCardsNr;
        private Integer deliveryId;
        private String sysPrin;
        private Character cycle;
        private String frstUpdtVendId;
        private String contactCd;
        private String contactPhNr;
        private String returnReasonCd;
        private String issuanceCd;
        private LocalDateTime issuanceDt;
        private String workstationNameTx;
        private String operatorCd;
        private String barcodeTypeCd;
        private String fileSent;
        private String postageBilled;
        private Boolean issuedByAmex;
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

        private String client;
        private List<AccountTransactionDTO> accountTransactions;

        public Builder caseNumber(String caseNumber) { this.caseNumber = caseNumber; return this; }
        public Builder piId(String piId) { this.piId = piId; return this; }
        public Builder customerId(String customerId) { this.customerId = customerId; return this; }
        public Builder primaryPiId(String primaryPiId) { this.primaryPiId = primaryPiId; return this; }
        public Builder account(String account) { this.account = account; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder hmPhone(String hmPhone) { this.hmPhone = hmPhone; return this; }
        public Builder wkPhone(String wkPhone) { this.wkPhone = wkPhone; return this; }
        public Builder entityCd(String entityCd) { this.entityCd = entityCd; return this; }
        public Builder roleCd(String roleCd) { this.roleCd = roleCd; return this; }
        public Builder piStatus(String piStatus) { this.piStatus = piStatus; return this; }
        public Builder status(Character status) { this.status = status; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }
        public Builder reason(Character reason) { this.reason = reason; return this; }
        public Builder subreason(Integer subreason) { this.subreason = subreason; return this; }
        public Builder disposition(Character disposition) { this.disposition = disposition; return this; }
        public Builder inHour(Integer inHour) { this.inHour = inHour; return this; }
        public Builder inDate(LocalDateTime inDate) { this.inDate = inDate; return this; }
        public Builder nextDate(LocalDateTime nextDate) { this.nextDate = nextDate; return this; }
        public Builder outDate(LocalDateTime outDate) { this.outDate = outDate; return this; }
        public Builder autoDate(LocalDateTime autoDate) { this.autoDate = autoDate; return this; }
        public Builder numCards(Integer numCards) { this.numCards = numCards; return this; }
        public Builder finalActionCardsNr(Integer finalActionCardsNr) { this.finalActionCardsNr = finalActionCardsNr; return this; }
        public Builder deliveryId(Integer deliveryId) { this.deliveryId = deliveryId; return this; }
        public Builder sysPrin(String sysPrin) { this.sysPrin = sysPrin; return this; }
        public Builder cycle(Character cycle) { this.cycle = cycle; return this; }
        public Builder frstUpdtVendId(String id) { this.frstUpdtVendId = id; return this; }
        public Builder contactCd(String cd) { this.contactCd = cd; return this; }
        public Builder contactPhNr(String ph) { this.contactPhNr = ph; return this; }
        public Builder returnReasonCd(String cd) { this.returnReasonCd = cd; return this; }
        public Builder issuanceCd(String cd) { this.issuanceCd = cd; return this; }
        public Builder issuanceDt(LocalDateTime dt) { this.issuanceDt = dt; return this; }
        public Builder workstationNameTx(String tx) { this.workstationNameTx = tx; return this; }
        public Builder operatorCd(String cd) { this.operatorCd = cd; return this; }
        public Builder barcodeTypeCd(String cd) { this.barcodeTypeCd = cd; return this; }
        public Builder fileSent(String sent) { this.fileSent = sent; return this; }
        public Builder postageBilled(String billed) { this.postageBilled = billed; return this; }
        public Builder issuedByAmex(Boolean issued) { this.issuedByAmex = issued; return this; }
        public Builder recTypTx(String tx) { this.recTypTx = tx; return this; }
        public Builder srvcTypTx(String tx) { this.srvcTypTx = tx; return this; }
        public Builder mailerId(String id) { this.mailerId = id; return this; }
        public Builder as400ClientId(String id) { this.as400ClientId = id; return this; }
        public Builder as400SystemId(String id) { this.as400SystemId = id; return this; }
        public Builder bscSpplmntlId(String id) { this.bscSpplmntlId = id; return this; }
        public Builder origMlDt(LocalDateTime dt) { this.origMlDt = dt; return this; }
        public Builder msgId(String id) { this.msgId = id; return this; }
        public Builder mlMthd(String method) { this.mlMthd = method; return this; }
        public Builder sourceFile(String file) { this.sourceFile = file; return this; }
        public Builder custId(String id) { this.custId = id; return this; }
        public Builder msIssueDate(String date) { this.msIssueDate = date; return this; }
        public Builder custId2(String id) { this.custId2 = id; return this; }
        public Builder mktCd(String cd) { this.mktCd = cd; return this; }
        public Builder accountTokenid(String id) { this.accountTokenid = id; return this; }
        public Builder piIdTokenid(String id) { this.piIdTokenid = id; return this; }
        public Builder primaryPiIdTokenid(String id) { this.primaryPiIdTokenid = id; return this; }

        public Builder client(String client) { this.client = client; return this; }

        public Builder accountTransactions(List<AccountTransactionDTO> accountTransactions) {
            this.accountTransactions = accountTransactions;
            return this;
        }

        public CaseDTO build() {
            return new CaseDTO(this);
        }
    }


    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Character getReason() {
        return reason;
    }

    public void setReason(Character reason) {
        this.reason = reason;
    }

    public Integer getSubreason() {
        return subreason;
    }

    public void setSubreason(Integer subreason) {
        this.subreason = subreason;
    }

    public Character getDisposition() {
        return disposition;
    }

    public void setDisposition(Character disposition) {
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

    public Character getCycle() {
        return cycle;
    }

    public void setCycle(Character cycle) {
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

    public String getWorkstationNameTx() {
        return workstationNameTx;
    }

    public void setWorkstationNameTx(String workstationNameTx) {
        this.workstationNameTx = workstationNameTx;
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

    public String getFileSent() {
        return fileSent;
    }

    public void setFileSent(String fileSent) {
        this.fileSent = fileSent;
    }

    public String getPostageBilled() {
        return postageBilled;
    }

    public void setPostageBilled(String postageBilled) {
        this.postageBilled = postageBilled;
    }

    public Boolean getIssuedByAmex() {
        return issuedByAmex;
    }

    public void setIssuedByAmex(Boolean issuedByAmex) {
        this.issuedByAmex = issuedByAmex;
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

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getMsIssueDate() {
        return msIssueDate;
    }

    public void setMsIssueDate(String msIssueDate) {
        this.msIssueDate = msIssueDate;
    }

    public String getCustId2() {
        return custId2;
    }

    public void setCustId2(String custId2) {
        this.custId2 = custId2;
    }

    public String getMktCd() {
        return mktCd;
    }

    public void setMktCd(String mktCd) {
        this.mktCd = mktCd;
    }

    public String getAccountTokenid() {
        return accountTokenid;
    }

    public void setAccountTokenid(String accountTokenid) {
        this.accountTokenid = accountTokenid;
    }

    public String getPiIdTokenid() {
        return piIdTokenid;
    }

    public void setPiIdTokenid(String piIdTokenid) {
        this.piIdTokenid = piIdTokenid;
    }

    public String getPrimaryPiIdTokenid() {
        return primaryPiIdTokenid;
    }

    public void setPrimaryPiIdTokenid(String primaryPiIdTokenid) {
        this.primaryPiIdTokenid = primaryPiIdTokenid;
    }

    public List<AccountTransactionDTO> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransactionDTO> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }
}
