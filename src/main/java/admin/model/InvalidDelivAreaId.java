package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InvalidDelivAreaId implements Serializable {

    @Column(name = "SYS_PRIN", nullable = false, length = 12)
    private String sysPrin;

    @Column(name = "AREA", nullable = false, length = 3)
    private String area;

    public InvalidDelivAreaId() {}

    public InvalidDelivAreaId(String sysPrin, String area) {
        this.sysPrin = sysPrin;
        this.area = area;
    }

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidDelivAreaId)) return false;
        InvalidDelivAreaId that = (InvalidDelivAreaId) o;
        return Objects.equals(sysPrin, that.sysPrin) &&
                Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sysPrin, area);
    }
}

