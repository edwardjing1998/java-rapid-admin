package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VendorSentToId implements Serializable {

    public VendorSentToId(){
    }
    public VendorSentToId(String vendId, String sysPrin ){
        this.vendId = vendId;
        this.sysPrin = sysPrin;
    }

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }

    public String getVendId() {
        return vendId;
    }

    public void setVendId(String vendId) {
        this.vendId = vendId;
    }

    @Column(name = "sys_prin", length = 8, nullable = false)
    private String sysPrin;

    @Column(name = "vend_id", length = 3, nullable = false)
    private String vendId;
}

