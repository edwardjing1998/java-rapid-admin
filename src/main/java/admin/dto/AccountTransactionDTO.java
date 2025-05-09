package admin.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountTransactionDTO {

    private String caseNumber;
    private BigDecimal transNo;
    private LocalDateTime dateTime;

    private String piId;
    private String account;
    private String actionId;
    private String uid;
    private String documentNo;
    private String sysPrin;
    private Integer noCards;
    private String actionReason;
    private Integer operatorTime;
    private String workstationName;
    private Short postageCategoryCd;
    private String altAcctId;
    private String memberSeqId;

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public BigDecimal getTransNo() {
        return transNo;
    }

    public void setTransNo(BigDecimal transNo) {
        this.transNo = transNo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

}

