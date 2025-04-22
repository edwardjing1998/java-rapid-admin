package admin.dto;

public class InvalidDelivAreaDTO {

    private Long id;
    private String area;
    private String sysPrin;

    // Constructors
    public InvalidDelivAreaDTO() {}

    public InvalidDelivAreaDTO(Long id, String area, String sysPrin) {
        this.id = id;
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
