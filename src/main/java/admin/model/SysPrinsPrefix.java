package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SYS_PRINS_PREFIX")
public class SysPrinsPrefix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prefix_id")
    private Long prefixId;

    @Column(name = "billing_sp", nullable = false)
    private String billingSp;

    @Column(name = "prefix", nullable = false)
    private String prefix;

    @Column(name = "atm_cash_rule")
    private String atmCashRule;

    // Constructors
    public SysPrinsPrefix() {
    }

    public SysPrinsPrefix(String billingSp, String prefix, String atmCashRule) {
        this.billingSp = billingSp;
        this.prefix = prefix;
        this.atmCashRule = atmCashRule;
    }

    // Getters and Setters

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
