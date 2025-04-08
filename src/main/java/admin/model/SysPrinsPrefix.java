package admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SYS_PRINS_PREFIX")
public class SysPrinsPrefix {

    @Id
    @Column(name = "prefix_id")
    private Long prefixId;

    @Column(name = "prefix", nullable = false)
    private String prefix;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    public SysPrinsPrefix() {
    }

    public SysPrinsPrefix(Long prefixId, String prefix, String description, Client client) {
        this.prefixId = prefixId;
        this.prefix = prefix;
        this.description = description;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "SysPrinsPrefix{" +
                "prefixId=" + prefixId +
                ", prefix='" + prefix + '\'' +
                ", description='" + description + '\'' +
                '}';
        // Avoid printing client to prevent lazy loading issues / infinite loop
    }
}
