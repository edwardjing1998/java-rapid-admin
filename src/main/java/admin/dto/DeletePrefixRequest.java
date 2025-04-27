package admin.dto;

public class DeletePrefixRequest {

    private String billingSp;
    private String prefix;
    private String atmCashRule;

    public DeletePrefixRequest() {
    }

    public String getBillingSp() {
        return billingSp;
    }

    public void setBillingSp(String billingSp) {
        this.billingSp = billingSp;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAtmCashRule() {
        return atmCashRule;
    }

    public void setAtmCashRule(String atmCashRule) {
        this.atmCashRule = atmCashRule;
    }
}
