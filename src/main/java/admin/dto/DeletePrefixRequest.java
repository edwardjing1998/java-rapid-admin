// DeletePrefixRequest.java
package admin.dto;

public class DeletePrefixRequest {
    private String billingSp;
    private String prefix;

    // Getters and Setters
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
}
