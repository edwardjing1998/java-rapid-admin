package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "INVALID_DELIV_AREAS")
public class InvalidDelivArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "client", referencedColumnName = "client"),
            @JoinColumn(name = "sys_prin", referencedColumnName = "sys_prin")
    })
    private SysPrin sysPrin;

    // Constructor, getters, and setters
    public InvalidDelivArea() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public SysPrin getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(SysPrin sysPrin) {
        this.sysPrin = sysPrin;
    }

    public String getClient() {
        return sysPrin != null ? sysPrin.getId().getClient() : null;
    }

    public String getSysPrinCode() {
        return sysPrin != null ? sysPrin.getId().getSysPrin() : null;
    }
}

