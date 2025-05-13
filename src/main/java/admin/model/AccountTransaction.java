package admin.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNT_TRANS")
public class AccountTransaction {

    @EmbeddedId
    private AccountTransactionId id;

    @Column(name = "PI_ID", length = 16)
    private String piId;

    @Column(name = "account", length = 16)
    private String account;

    @Column(name = "action_id", length = 3)
    private String actionId;

    @Column(name = "uid", length = 10)
    private String uid;

    @Column(name = "document_no", length = 25)
    private String documentNo;

    @Column(name = "sys_prin", length = 12)
    private String sysPrin;

    @Column(name = "no_cards")
    private Integer noCards;

    @Column(name = "action_reason", length = 255)
    private String actionReason;

    @Column(name = "Operator_Time")
    private Integer operatorTime;

    @Column(name = "workstation_name_tx", length = 18)
    private String workstationName;

    @Column(name = "Postage_Category_cd")
    private Short postageCategoryCd;

    @Column(name = "Alt_Acct_ID", length = 19)
    private String altAcctId;

    @Column(name = "Member_Seq_ID", length = 5)
    private String memberSeqId;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("caseNumber")
    @JoinColumn(name = "case_number")
    private Case caseEntity;

    // Getters and setters for all fields...

    public AccountTransactionId getId() {
        return id;
    }

    public void setId(AccountTransactionId id) {
        this.id = id;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }

    public Integer getNoCards() {
        return noCards;
    }

    public void setNoCards(Integer noCards) {
        this.noCards = noCards;
    }

    public String getActionReason() {
        return actionReason;
    }

    public void setActionReason(String actionReason) {
        this.actionReason = actionReason;
    }

    public Integer getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Integer operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getWorkstationName() {
        return workstationName;
    }

    public void setWorkstationName(String workstationName) {
        this.workstationName = workstationName;
    }

    public Short getPostageCategoryCd() {
        return postageCategoryCd;
    }

    public void setPostageCategoryCd(Short postageCategoryCd) {
        this.postageCategoryCd = postageCategoryCd;
    }

    public String getAltAcctId() {
        return altAcctId;
    }

    public void setAltAcctId(String altAcctId) {
        this.altAcctId = altAcctId;
    }

    public String getMemberSeqId() {
        return memberSeqId;
    }

    public void setMemberSeqId(String memberSeqId) {
        this.memberSeqId = memberSeqId;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }
}

