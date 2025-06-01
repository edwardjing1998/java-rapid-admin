package admin.dto;

import java.io.Serializable;

/**
 * Data-transfer object for rows in VENDOR_SENT_TO.
 * Holds only the fields you need at the UI / API level.
 */
public class VendorRecivedFromDTO implements Serializable {

    private String  sysPrin;      // PK part 1  -- same length as SYS_PRIN column
    private String  vendorId;     // PK part 2  -- Vend_id (3 chars)
    private Boolean queForMail;   // queformail_cd

    private String  vendorName;   // ⬅️ NEW


    /* ========== constructors ========== */
    public VendorRecivedFromDTO() { }

    public VendorRecivedFromDTO(String sysPrin, String vendorId, Boolean queForMail, String vendorName) {
        this.sysPrin     = sysPrin;
        this.vendorId    = vendorId;
        this.queForMail  = queForMail;
        this.vendorName = vendorName;
    }

    public String  getSysPrin()            { return sysPrin; }
    public void    setSysPrin(String s)    { this.sysPrin = s; }

    public String  getVendorId()           { return vendorId; }
    public void    setVendorId(String vendorId)   { this.vendorId = vendorId; }

    public Boolean getQueForMail()         { return queForMail; }
    public void    setQueForMail(Boolean queForMail){ this.queForMail = queForMail; }

    public String  getVendorName()            { return vendorName; }
    public void    setVendorName(String vendorName)    { this.vendorName = vendorName; }

    /* ========== convenience ========== */
    @Override
    public String toString() {
        return "VendorSentToDTO{" +
                "sysPrin='"    + sysPrin   + '\'' +
                ", vendorId='" + vendorId  + '\'' +
                ", queForMail=" + queForMail +
                '}';
    }
}
