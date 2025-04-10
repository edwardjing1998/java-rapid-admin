package admin.dto;

public class SysPrinsPrefixDTO {
    private Long prefixId;
    private String billingSp;
    private String prefix;
    private String atmCashRule;

    public SysPrinsPrefixDTO() {}

    public SysPrinsPrefixDTO(Long prefixId, String billingSp, String prefix, String atmCashRule) {
        this.prefixId = prefixId;
        this.billingSp = billingSp;
        this.prefix = prefix;
        this.atmCashRule = atmCashRule;
    }

    public Long getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(Long prefixId) {
        this.prefixId = prefixId;
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
