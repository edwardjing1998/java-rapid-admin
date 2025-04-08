package admin.dto;

public class SysPrinsPrefixDTO {
    private Long prefixId;
    private String prefix;
    private String description;
    private String client;

    public SysPrinsPrefixDTO(Long prefixId, String prefix, String description) {
        this.prefixId = prefixId;
        this.prefix = prefix;
        this.description = description;
    }

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