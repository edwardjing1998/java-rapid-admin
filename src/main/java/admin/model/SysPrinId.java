package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SysPrinId implements Serializable {

    @Column(name = "client")
    private String client;

    @Column(name = "sys_prin")
    private String sysPrin;

    // Default constructor
    public SysPrinId() {
    }

    // Parameterized constructor
    public SysPrinId(String client, String sysPrin) {
        this.client = client;
        this.sysPrin = sysPrin;
    }

    // Getters and Setters
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSysPrin() {
        return sysPrin;
    }

    public void setSysPrin(String sysPrin) {
        this.sysPrin = sysPrin;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SysPrinId)) return false;
        SysPrinId that = (SysPrinId) o;
        return Objects.equals(client, that.client) &&
                Objects.equals(sysPrin, that.sysPrin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, sysPrin);
    }
}
