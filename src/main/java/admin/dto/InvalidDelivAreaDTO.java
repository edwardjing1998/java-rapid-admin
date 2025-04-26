package admin.dto;

public class InvalidDelivAreaDTO {

    private String area;
    private String sysPrin;

    // Constructors
    public InvalidDelivAreaDTO() {}

    public InvalidDelivAreaDTO(String area, String sysPrin) {
        this.area = area;
        this.sysPrin = sysPrin;
    }

    // Getters & Setters
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
