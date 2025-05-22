package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CASES")
public class Case {

    @Id
    @Column(name = "case_number", length = 12, nullable = false)
    private String caseNumber;

    @Column(name = "pi_id", length = 16)
    private String piId;

    @Column(name = "customer_id", length = 24)
    private String customerId;

    @Column(name = "primary_pi_id", length = 16)
    private String primaryPiId;

    @Column(name = "account", length = 16)
    private String account;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "first_name", length = 16)
    private String firstName;

    @Column(name = "hm_phone", length = 14)
    private String hmPhone;

    @Column(name = "wk_phone", length = 14)
    private String wkPhone;

    @Column(name = "entity_cd", length = 1)
    private String entityCd;

    @Column(name = "role_cd", length = 2)
    private String roleCd;

    @Column(name = "pi_status", length = 1)
    private String piStatus;

    @Column(name = "status", length = 1)
    private Character status;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "reason", length = 1)
    private Character reason;

    @Column(name = "subreason")
    private Integer subreason;

    @Column(name = "disposition", length = 1)
    private Character disposition;

    @Column(name = "in_hour")
    private Integer inHour;

    @Column(name = "in_date")
    private LocalDateTime inDate;

    @Column(name = "next_date")
    private LocalDateTime nextDate;

    @Column(name = "out_date")
    private LocalDateTime outDate;

    @Column(name = "auto_date")
    private LocalDateTime autoDate;

    @Column(name = "num_cards")
    private Integer numCards;

    @Column(name = "final_action_cards_nr")
    private Integer finalActionCardsNr;

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "sys_prin", length = 12)
    private String sysPrin;

    @Column(name = "cycle", length = 1)
    private Character cycle;

    @Column(name = "Frst_Updt_Vend_id", length = 3)
    private String frstUpdtVendId;

    @Column(name = "Contact_cd", length = 1)
    private String contactCd;

    @Column(name = "Contact_Ph_nr", length = 18)
    private String contactPhNr;

    @Column(name = "Return_Reason_cd", length = 2)
    private String returnReasonCd;

    @Column(name = "Issuance_cd", length = 1)
    private String issuanceCd;

    @Column(name = "issuance_dt")
    private LocalDateTime issuanceDt;

    @Column(name = "workstation_name_tx", length = 18)
    private String workstationNameTx;

    @Column(name = "Operator_CD", length = 2)
    private String operatorCd;

    @Column(name = "Barcode_Type_CD", length = 1)
    private String barcodeTypeCd;

    @Column(name = "file_sent", length = 1)
    private String fileSent;

    @Column(name = "Postage_Billed", length = 1)
    private String postageBilled;

    @Column(name = "Issued_by_Amex")
    private Boolean issuedByAmex;

    @Column(name = "rec_typ_tx", length = 2)
    private String recTypTx;

    @Column(name = "srvc_typ_tx", length = 3)
    private String srvcTypTx;

    @Column(name = "mailer_id", length = 9)
    private String mailerId;

    @Column(name = "AS400_client_id", length = 4)
    private String as400ClientId;

    @Column(name = "AS400_system_id", length = 8)
    private String as400SystemId;

    @Column(name = "bsc_spplmntl_id", length = 1)
    private String bscSpplmntlId;

    @Column(name = "orig_ml_dt")
    private LocalDateTime origMlDt;

    @Column(name = "msg_id", length = 40)
    private String msgId;

    @Column(name = "ml_mthd", length = 30)
    private String mlMthd;

    @Column(name = "source_file", length = 16)
    private String sourceFile;

    @Column(name = "cust_id", length = 9)
    private String custId;

    @Column(name = "ms_issue_date", length = 5)
    private String msIssueDate;

    @Column(name = "cust_id2", length = 9)
    private String custId2;

    @Column(name = "mkt_cd", length = 2)
    private String mktCd;

    @Column(name = "account_tokenid", length = 16)
    private String accountTokenid;

    @Column(name = "pi_id_tokenid", length = 16)
    private String piIdTokenid;

    @Column(name = "primary_pi_id_tokenid", length = 16)
    private String primaryPiIdTokenid;

    @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountTransaction> accountTransactions = new ArrayList<>();

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

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }
}
