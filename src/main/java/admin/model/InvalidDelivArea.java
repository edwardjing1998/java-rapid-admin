package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "INVALID_DELIV_AREAS")
public class InvalidDelivArea {

    @EmbeddedId
    private InvalidDelivAreaId id;

    public InvalidDelivArea() {}

    public InvalidDelivArea(InvalidDelivAreaId id) {
        this.id = id;
    }

    public InvalidDelivArea(String area, String sysPrin) {
        this.id = new InvalidDelivAreaId(area, sysPrin);
    }

    public InvalidDelivAreaId getId() {
        return id;
    }

    public void setId(InvalidDelivAreaId id) {
        this.id = id;
    }

    public String getSysPrin() {
        return id != null ? id.getSysPrin() : null;
    }

    public String getArea() {
        return id != null ? id.getArea() : null;
    }
}
