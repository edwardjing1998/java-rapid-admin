package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "INVALID_DELIV_AREAS")
public class InvalidDelivArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String area;

    @Column(name = "SYS_PRIN", nullable = false, length = 100)
    private String sysPrin;

    // Constructors
    public InvalidDelivArea() {}

    public InvalidDelivArea(String area, String sysPrin) {
        this.area = area;
        this.sysPrin = sysPrin;
    }

    // Getters & Setters
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

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }
}
