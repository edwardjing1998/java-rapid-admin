package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SysPrinsPrefixId implements Serializable {

    @Column(name = "billing_sp", length = 8, nullable = false)
    private String billingSp;

    @Column(name = "prefix", length = 8, nullable = false)
    private String prefix;

    @Column(name = "atm_cash_rule", length = 1, nullable = false)
    private String atmCashRule;

    public SysPrinsPrefixId() {
    }

    public SysPrinsPrefixId(String billingSp, String prefix, String atmCashRule) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SysPrinsPrefixId)) return false;
        SysPrinsPrefixId that = (SysPrinsPrefixId) o;
        return Objects.equals(billingSp, that.billingSp) &&
                Objects.equals(prefix, that.prefix) &&
                Objects.equals(atmCashRule, that.atmCashRule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingSp, prefix, atmCashRule);
    }
}
