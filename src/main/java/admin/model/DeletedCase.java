package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deleted_cases")
public class DeletedCase {

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
    private String homePhone;

    @Column(name = "wk_phone", length = 14)
    private String workPhone;

    @Column(name = "entity_cd", length = 1)
    private String entityCode;

    @Column(name = "role_cd", length = 2)
    private String roleCode;

    @Column(name = "pi_status", length = 1)
    private String piStatus;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "reason", length = 1)
    private String reason;

    @Column(name = "subreason")
    private Integer subreason;

    @Column(name = "disposition", length = 1)
    private String disposition;

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
    private Integer finalActionCardsNumber;

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "sys_prin", length = 8)
    private String sysPrin;

    @Column(name = "cycle", length = 1)
    private String cycle;

    @Column(name = "Frst_Updt_Vend_id", length = 3)
    private String firstUpdateVendorId;

    @Column(name = "Contact_cd", length = 1)
    private String contactCode;

    @Column(name = "Contact_Ph_nr", length = 18)
    private String contactPhoneNumber;

    @Column(name = "Return_Reason_cd", length = 2)
    private String returnReasonCode;

    @Column(name = "Issuance_cd", length = 1)
    private String issuanceCode;

    @Column(name = "issuance_dt")
    private LocalDateTime issuanceDate;

    @Column(name = "workstation_name_tx", length = 18)
    private String workstationName;

    @Column(name = "operator_cd", length = 2)
    private String operatorCode;

    @Column(name = "barcode_type_cd", length = 1)
    private String barcodeTypeCode;

    @Column(name = "rec_typ_tx", length = 2)
    private String recordTypeText;

    @Column(name = "srvc_typ_tx", length = 3)
    private String serviceTypeText;

    @Column(name = "mailer_id", length = 9)
    private String mailerId;

    @Column(name = "as400_client_id", length = 4)
    private String as400ClientId;

    @Column(name = "as400_system_id", length = 8)
    private String as400SystemId;

    @Column(name = "BSC_SPPLMNTL_ID", length = 1)
    private String basicSupplementalId;

    @Column(name = "orig_ml_dt")
    private LocalDateTime originalMailDate;

    @Column(name = "msg_id", length = 40)
    private String messageId;

    @Column(name = "ml_mthd", length = 30)
    private String mailMethod;

    @Column(name = "source_file", length = 16)
    private String sourceFile;

    @Column(name = "cust_id", length = 9)
    private String customerIdField;

    @Column(name = "ms_issue_date", length = 5)
    private String msIssueDate;

    @Column(name = "cust_id2", length = 9)
    private String customerId2;

    @Column(name = "mkt_cd", length = 2)
    private String marketCode;

    @Column(name = "account_tokenid", length = 16)
    private String accountTokenId;

    @Column(name = "pi_id_tokenid", length = 16)
    private String piIdTokenId;

    @Column(name = "primary_pi_id_tokenid", length = 16)
    private String primaryPiIdTokenId;

    // Default constructor
    public DeletedCase() {}

    // Getter and Setter methods
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
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

    public Integer getFinalActionCardsNumber() {
        return finalActionCardsNumber;
    }

    public void setFinalActionCardsNumber(Integer finalActionCardsNumber) {
        this.finalActionCardsNumber = finalActionCardsNumber;
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

    public String getFirstUpdateVendorId() {
        return firstUpdateVendorId;
    }

    public void setFirstUpdateVendorId(String firstUpdateVendorId) {
        this.firstUpdateVendorId = firstUpdateVendorId;
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getReturnReasonCode() {
        return returnReasonCode;
    }

    public void setReturnReasonCode(String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }

    public String getIssuanceCode() {
        return issuanceCode;
    }

    public void setIssuanceCode(String issuanceCode) {
        this.issuanceCode = issuanceCode;
    }

    public LocalDateTime getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(LocalDateTime issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public String getWorkstationName() {
        return workstationName;
    }

    public void setWorkstationName(String workstationName) {
        this.workstationName = workstationName;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getBarcodeTypeCode() {
        return barcodeTypeCode;
    }

    public void setBarcodeTypeCode(String barcodeTypeCode) {
        this.barcodeTypeCode = barcodeTypeCode;
    }

    public String getRecordTypeText() {
        return recordTypeText;
    }

    public void setRecordTypeText(String recordTypeText) {
        this.recordTypeText = recordTypeText;
    }

    public String getServiceTypeText() {
        return serviceTypeText;
    }

    public void setServiceTypeText(String serviceTypeText) {
        this.serviceTypeText = serviceTypeText;
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

    public String getBasicSupplementalId() {
        return basicSupplementalId;
    }

    public void setBasicSupplementalId(String basicSupplementalId) {
        this.basicSupplementalId = basicSupplementalId;
    }

    public LocalDateTime getOriginalMailDate() {
        return originalMailDate;
    }

    public void setOriginalMailDate(LocalDateTime originalMailDate) {
        this.originalMailDate = originalMailDate;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMailMethod() {
        return mailMethod;
    }

    public void setMailMethod(String mailMethod) {
        this.mailMethod = mailMethod;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getCustomerIdField() {
        return customerIdField;
    }

    public void setCustomerIdField(String customerIdField) {
        this.customerIdField = customerIdField;
    }

    public String getMsIssueDate() {
        return msIssueDate;
    }

    public void setMsIssueDate(String msIssueDate) {
        this.msIssueDate = msIssueDate;
    }

    public String getCustomerId2() {
        return customerId2;
    }

    public void setCustomerId2(String customerId2) {
        this.customerId2 = customerId2;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getAccountTokenId() {
        return accountTokenId;
    }

    public void setAccountTokenId(String accountTokenId) {
        this.accountTokenId = accountTokenId;
    }

    public String getPiIdTokenId() {
        return piIdTokenId;
    }

    public void setPiIdTokenId(String piIdTokenId) {
        this.piIdTokenId = piIdTokenId;
    }

    public String getPrimaryPiIdTokenId() {
        return primaryPiIdTokenId;
    }

    public void setPrimaryPiIdTokenId(String primaryPiIdTokenId) {
        this.primaryPiIdTokenId = primaryPiIdTokenId;
    }
}
