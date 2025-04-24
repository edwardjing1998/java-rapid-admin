package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCTIVITY_WORK")
public class ProductivityWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERID", length = 10)
    private String userId;

    @Column(name = "USER_NAME", length = 25)
    private String userName;

    @Column(name = "FROMDATE")
    private LocalDateTime fromDate;

    @Column(name = "TODATE")
    private LocalDateTime toDate;

    @Column(name = "MAILED_COUNT")
    private Integer mailedCount;

    @Column(name = "MAILED_TIME")
    private Integer mailedTime;

    @Column(name = "MAILED_CARDS")
    private Integer mailedCards;

    @Column(name = "RETURNED_COUNT")
    private Integer returnedCount;

    @Column(name = "RETURNED_TIME")
    private Integer returnedTime;

    @Column(name = "RETURNED_CARDS")
    private Integer returnedCards;

    @Column(name = "DESTROYED_COUNT")
    private Integer destroyedCount;

    @Column(name = "DESTROYED_TIME")
    private Integer destroyedTime;

    @Column(name = "DESTROYED_CARDS")
    private Integer destroyedCards;

    @Column(name = "HOLD_COUNT")
    private Integer holdCount;

    @Column(name = "HOLD_TIME")
    private Integer holdTime;

    @Column(name = "HOLD_CARDS")
    private Integer holdCards;

    @Column(name = "RESEARCH_COUNT")
    private Integer researchCount;

    @Column(name = "RESEARCH_TIME")
    private Integer researchTime;

    @Column(name = "RESEARCH_CARDS")
    private Integer researchCards;

    @Column(name = "PAYMENT_COUNT")
    private Integer paymentCount;

    @Column(name = "PAYMENT_TIME")
    private Integer paymentTime;

    @Column(name = "PAYMENT_CARDS")
    private Integer paymentCards;

    @Column(name = "ADDRESS_COUNT")
    private Integer addressCount;

    @Column(name = "ADDRESS_TIME")
    private Integer addressTime;

    @Column(name = "ADDRESS_CARDS")
    private Integer addressCards;

    @Column(name = "CORRES_COUNT")
    private Integer corresCount;

    @Column(name = "CORRES_TIME")
    private Integer corresTime;

    @Column(name = "CORRES_CARDS")
    private Integer corresCards;

    @Column(name = "BULKDEST_COUNT")
    private Integer bulkDestCount;

    @Column(name = "BULKDEST_TIME")
    private Integer bulkDestTime;

    @Column(name = "BULKDEST_CARDS")
    private Integer bulkDestCards;

    @Column(name = "BULKRET_COUNT")
    private Integer bulkRetCount;

    @Column(name = "BULKRET_TIME")
    private Integer bulkRetTime;

    @Column(name = "BULKRET_CARDS")
    private Integer bulkRetCards;

    @Column(name = "SPECIAL_COUNT")
    private Integer specialCount;

    @Column(name = "SPECIAL_CARDS", nullable = false)
    private Integer specialCards;

    @Column(name = "SPECIAL_TIME")
    private Integer specialTime;

    @Column(name = "PRIVATE_LABEL_COUNT")
    private Integer privateLabelCount;

    @Column(name = "PRIVATE_LABEL_TIME")
    private Integer privateLabelTime;

    @Column(name = "PRIVATE_LABEL_CARDS")
    private Integer privateLabelCards;

    @Column(name = "METALCARD_COUNT")
    private Integer metalCardCount;

    @Column(name = "METALCARD_TIME")
    private Integer metalCardTime;

    @Column(name = "METAL_CARDS")
    private Integer metalCards;

    @Column(name = "ROBOT_LABEL_TOTAL")
    private Integer robotLabelTotal;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public Integer getMailedCount() {
        return mailedCount;
    }

    public void setMailedCount(Integer mailedCount) {
        this.mailedCount = mailedCount;
    }

    public Integer getMailedTime() {
        return mailedTime;
    }

    public void setMailedTime(Integer mailedTime) {
        this.mailedTime = mailedTime;
    }

    public Integer getMailedCards() {
        return mailedCards;
    }

    public void setMailedCards(Integer mailedCards) {
        this.mailedCards = mailedCards;
    }

    public Integer getReturnedCount() {
        return returnedCount;
    }

    public void setReturnedCount(Integer returnedCount) {
        this.returnedCount = returnedCount;
    }

    public Integer getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(Integer returnedTime) {
        this.returnedTime = returnedTime;
    }

    public Integer getReturnedCards() {
        return returnedCards;
    }

    public void setReturnedCards(Integer returnedCards) {
        this.returnedCards = returnedCards;
    }

    public Integer getDestroyedCount() {
        return destroyedCount;
    }

    public void setDestroyedCount(Integer destroyedCount) {
        this.destroyedCount = destroyedCount;
    }

    public Integer getDestroyedTime() {
        return destroyedTime;
    }

    public void setDestroyedTime(Integer destroyedTime) {
        this.destroyedTime = destroyedTime;
    }

    public Integer getDestroyedCards() {
        return destroyedCards;
    }

    public void setDestroyedCards(Integer destroyedCards) {
        this.destroyedCards = destroyedCards;
    }

    public Integer getHoldCount() {
        return holdCount;
    }

    public void setHoldCount(Integer holdCount) {
        this.holdCount = holdCount;
    }

    public Integer getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(Integer holdTime) {
        this.holdTime = holdTime;
    }

    public Integer getHoldCards() {
        return holdCards;
    }

    public void setHoldCards(Integer holdCards) {
        this.holdCards = holdCards;
    }

    public Integer getResearchCount() {
        return researchCount;
    }

    public void setResearchCount(Integer researchCount) {
        this.researchCount = researchCount;
    }

    public Integer getResearchTime() {
        return researchTime;
    }

    public void setResearchTime(Integer researchTime) {
        this.researchTime = researchTime;
    }

    public Integer getResearchCards() {
        return researchCards;
    }

    public void setResearchCards(Integer researchCards) {
        this.researchCards = researchCards;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public Integer getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Integer paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Integer getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(Integer paymentCards) {
        this.paymentCards = paymentCards;
    }

    public Integer getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(Integer addressCount) {
        this.addressCount = addressCount;
    }

    public Integer getAddressTime() {
        return addressTime;
    }

    public void setAddressTime(Integer addressTime) {
        this.addressTime = addressTime;
    }

    public Integer getAddressCards() {
        return addressCards;
    }

    public void setAddressCards(Integer addressCards) {
        this.addressCards = addressCards;
    }

    public Integer getCorresCount() {
        return corresCount;
    }

    public void setCorresCount(Integer corresCount) {
        this.corresCount = corresCount;
    }

    public Integer getCorresTime() {
        return corresTime;
    }

    public void setCorresTime(Integer corresTime) {
        this.corresTime = corresTime;
    }

    public Integer getCorresCards() {
        return corresCards;
    }

    public void setCorresCards(Integer corresCards) {
        this.corresCards = corresCards;
    }

    public Integer getBulkDestCount() {
        return bulkDestCount;
    }

    public void setBulkDestCount(Integer bulkDestCount) {
        this.bulkDestCount = bulkDestCount;
    }

    public Integer getBulkDestTime() {
        return bulkDestTime;
    }

    public void setBulkDestTime(Integer bulkDestTime) {
        this.bulkDestTime = bulkDestTime;
    }

    public Integer getBulkDestCards() {
        return bulkDestCards;
    }

    public void setBulkDestCards(Integer bulkDestCards) {
        this.bulkDestCards = bulkDestCards;
    }

    public Integer getBulkRetCount() {
        return bulkRetCount;
    }

    public void setBulkRetCount(Integer bulkRetCount) {
        this.bulkRetCount = bulkRetCount;
    }

    public Integer getBulkRetTime() {
        return bulkRetTime;
    }

    public void setBulkRetTime(Integer bulkRetTime) {
        this.bulkRetTime = bulkRetTime;
    }

    public Integer getBulkRetCards() {
        return bulkRetCards;
    }

    public void setBulkRetCards(Integer bulkRetCards) {
        this.bulkRetCards = bulkRetCards;
    }

    public Integer getSpecialCount() {
        return specialCount;
    }

    public void setSpecialCount(Integer specialCount) {
        this.specialCount = specialCount;
    }

    public Integer getSpecialCards() {
        return specialCards;
    }

    public void setSpecialCards(Integer specialCards) {
        this.specialCards = specialCards;
    }

    public Integer getSpecialTime() {
        return specialTime;
    }

    public void setSpecialTime(Integer specialTime) {
        this.specialTime = specialTime;
    }

    public Integer getPrivateLabelCount() {
        return privateLabelCount;
    }

    public void setPrivateLabelCount(Integer privateLabelCount) {
        this.privateLabelCount = privateLabelCount;
    }

    public Integer getPrivateLabelTime() {
        return privateLabelTime;
    }

    public void setPrivateLabelTime(Integer privateLabelTime) {
        this.privateLabelTime = privateLabelTime;
    }

    public Integer getPrivateLabelCards() {
        return privateLabelCards;
    }

    public void setPrivateLabelCards(Integer privateLabelCards) {
        this.privateLabelCards = privateLabelCards;
    }

    public Integer getMetalCardCount() {
        return metalCardCount;
    }

    public void setMetalCardCount(Integer metalCardCount) {
        this.metalCardCount = metalCardCount;
    }

    public Integer getMetalCardTime() {
        return metalCardTime;
    }

    public void setMetalCardTime(Integer metalCardTime) {
        this.metalCardTime = metalCardTime;
    }

    public Integer getMetalCards() {
        return metalCards;
    }

    public void setMetalCards(Integer metalCards) {
        this.metalCards = metalCards;
    }

    public Integer getRobotLabelTotal() {
        return robotLabelTotal;
    }

    public void setRobotLabelTotal(Integer robotLabelTotal) {
        this.robotLabelTotal = robotLabelTotal;
    }

}

