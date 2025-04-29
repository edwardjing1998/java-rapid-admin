package admin.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYS_PRINS_PREFIX")
public class SysPrinsPrefix {

    @EmbeddedId
    private SysPrinsPrefixId id = new SysPrinsPrefixId();

    public SysPrinsPrefix() {
    }

    public SysPrinsPrefix(SysPrinsPrefixId id) {
        this.id = id;
    }

    public SysPrinsPrefixId getId() {
        return id;
    }

    public void setId(SysPrinsPrefixId id) {
        this.id = id;
    }
}
