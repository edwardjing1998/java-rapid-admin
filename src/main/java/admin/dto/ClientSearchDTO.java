package admin.dto;

public class ClientSearchDTO {
    private String client;
    private String name;

    public ClientSearchDTO(String client, String name) {
        this.client = client;
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public String getName() {
        return name;
    }
}
