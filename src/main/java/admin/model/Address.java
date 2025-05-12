package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "case_number_id", length = 12, nullable = false)
    private String caseNumberId;

    @Column(name = "address_entity_cd", length = 1, nullable = false)
    private String addressEntityCd;

    @Column(name = "alternate_name_tx", length = 50)
    private String alternateName;

    @Column(name = "addr1_tx", length = 50)
    private String addr1;

    @Column(name = "addr2_tx", length = 50)
    private String addr2;

    @Column(name = "city_tx", length = 25)
    private String city;

    @Column(name = "state_tx", length = 2)
    private String state;

    @Column(name = "zip_cd", length = 10)
    private String zip;

    @Column(name = "Delivery_Point_CD", length = 2)
    private String deliveryPointCd;

    @Column(name = "addr3_tx", length = 50)
    private String addr3;

    @Column(name = "addr4_tx", length = 50)
    private String addr4;

    // Getters and Setters
    public String getCaseNumberId() {
        return caseNumberId;
    }

    public void setCaseNumberId(String caseNumberId) {
        this.caseNumberId = caseNumberId;
    }

    public String getAddressEntityCd() {
        return addressEntityCd;
    }

    public void setAddressEntityCd(String addressEntityCd) {
        this.addressEntityCd = addressEntityCd;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDeliveryPointCd() {
        return deliveryPointCd;
    }

    public void setDeliveryPointCd(String deliveryPointCd) {
        this.deliveryPointCd = deliveryPointCd;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getAddr4() {
        return addr4;
    }

    public void setAddr4(String addr4) {
        this.addr4 = addr4;
    }
}
