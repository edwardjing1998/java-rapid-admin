package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LabelsId implements Serializable {

    @Column(name = "text1", length = 50)
    private String text1;

    @Column(name = "text2", length = 50)
    private String text2;

    @Column(name = "text3", length = 50)
    private String text3;

    @Column(name = "text4", length = 50)
    private String text4;

    @Column(name = "text5", length = 50)
    private String text5;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "case_number", length = 16)
    private String caseNumber;

    @Column(name = "card_type_tx", length = 7, nullable = false)
    private String cardTypeTx;

    @Column(name = "bar_code_tx", length = 70)
    private String barCodeTx;

    @Column(name = "text3_addr3", length = 50)
    private String text3Addr3;

    @Column(name = "text3_addr4", length = 50)
    private String text3Addr4;

    // Getters and Setters
    public String getText1() { return text1; }
    public void setText1(String text1) { this.text1 = text1; }

    public String getText2() { return text2; }
    public void setText2(String text2) { this.text2 = text2; }

    public String getText3() { return text3; }
    public void setText3(String text3) { this.text3 = text3; }

    public String getText4() { return text4; }
    public void setText4(String text4) { this.text4 = text4; }

    public String getText5() { return text5; }
    public void setText5(String text5) { this.text5 = text5; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }

    public String getCardTypeTx() { return cardTypeTx; }
    public void setCardTypeTx(String cardTypeTx) { this.cardTypeTx = cardTypeTx; }

    public String getBarCodeTx() { return barCodeTx; }
    public void setBarCodeTx(String barCodeTx) { this.barCodeTx = barCodeTx; }

    public String getText3Addr3() { return text3Addr3; }
    public void setText3Addr3(String text3Addr3) { this.text3Addr3 = text3Addr3; }

    public String getText3Addr4() { return text3Addr4; }
    public void setText3Addr4(String text3Addr4) { this.text3Addr4 = text3Addr4; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LabelsId)) return false;
        LabelsId that = (LabelsId) o;
        return Objects.equals(text1, that.text1) &&
                Objects.equals(text2, that.text2) &&
                Objects.equals(text3, that.text3) &&
                Objects.equals(text4, that.text4) &&
                Objects.equals(text5, that.text5) &&
                Objects.equals(status, that.status) &&
                Objects.equals(type, that.type) &&
                Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(cardTypeTx, that.cardTypeTx) &&
                Objects.equals(barCodeTx, that.barCodeTx) &&
                Objects.equals(text3Addr3, that.text3Addr3) &&
                Objects.equals(text3Addr4, that.text3Addr4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text1, text2, text3, text4, text5, status, type, caseNumber,
                cardTypeTx, barCodeTx, text3Addr3, text3Addr4);
    }
}
