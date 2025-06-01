package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_sent_to")
public class VendorSentTo {

    public VendorSentTo(){}

    public VendorSentTo(VendorSentToId id, boolean queForMail){
        this.id = id;
        this.queForMail = queForMail;
    }
    @EmbeddedId
    private VendorSentToId id;

    public VendorSentToId getId() {
        return id;
    }

    public void setId(VendorSentToId id) {
        this.id = id;
    }

    public Boolean getQueForMail() {
        return queForMail;
    }

    public void setQueForMail(Boolean queForMail) {
        this.queForMail = queForMail;
    }

    @Column(name = "queformail_cd", nullable = false)
    private Boolean queForMail;
}
