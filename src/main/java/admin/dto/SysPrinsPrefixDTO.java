package admin.dto;

public class SysPrinsPrefixDTO {
    private Long prefixId;
    private String prefix;
    private String description;
    private String client;
    private ClientDTO clientDTO;

    public Long getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(Long prefixId) {
        this.prefixId = prefixId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    @Override
    public String toString() {
        return "SysPrinsPrefixDTO{" +
                "prefixId=" + prefixId +
                ", prefix='" + prefix + '\'' +
                ", description='" + description + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}