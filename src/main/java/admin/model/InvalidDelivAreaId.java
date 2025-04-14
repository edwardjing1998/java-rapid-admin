package admin.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class InvalidDelivAreaId implements Serializable {

    private String client;
    private String sysPrin;

    public InvalidDelivAreaId() {}

    public InvalidDelivAreaId(String client, String sysPrin) {
        this.client = client;
        this.sysPrin = sysPrin;
    }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getSysPrin() { return sysPrin; }
    public void setSysPrin(String sysPrin) { this.sysPrin = sysPrin; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidDelivAreaId that)) return false;
        return Objects.equals(client, that.client) &&
                Objects.equals(sysPrin, that.sysPrin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, sysPrin);
    }
}