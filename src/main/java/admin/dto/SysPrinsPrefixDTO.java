package admin.dto;

public class SysPrinsPrefixDTO {

    private String billingSp;
    private String prefix;
    private String atmCashRule;

    public SysPrinsPrefixDTO() {
    }

    public SysPrinsPrefixDTO(String billingSp, String prefix, String atmCashRule) {
        this.billingSp = billingSp;
        this.prefix = prefix;
        this.atmCashRule = atmCashRule;
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
