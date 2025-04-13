package admin.dto;

public class InvalidDelivAreaDTO {
    private Long id;
    private String area;

    private String client;
    private String sysPrin;

    public InvalidDelivAreaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getSysPrin() { return sysPrin; }
    public void setSysPrin(String sysPrin) { this.sysPrin = sysPrin; }
}
