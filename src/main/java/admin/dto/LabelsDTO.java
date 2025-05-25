package admin.dto;


public class LabelsDTO {
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;
    private boolean status;
    private String type;
    private String caseNumber;
    private String cardTypeTx;
    private String barCodeTx;
    private String text3Addr3;
    private String text3Addr4;

    public LabelsDTO() {}

    public LabelsDTO(String text1, String text2, String text3, String text4, String text5,
                  boolean status, String type, String caseNumber, String cardTypeTx,
                  String barCodeTx, String text3Addr3, String text3Addr4) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.status = status;
        this.type = type;
        this.caseNumber = caseNumber;
        this.cardTypeTx = cardTypeTx;
        this.barCodeTx = barCodeTx;
        this.text3Addr3 = text3Addr3;
        this.text3Addr4 = text3Addr4;
    }

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

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

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
}

