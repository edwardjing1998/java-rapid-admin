package admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientEmailId implements Serializable {

    @Column(name = "Client_ID")
    private String clientId;

    @Column(name = "Email_Address_tx")
    private String emailAddressTx;

    public ClientEmailId() {
    }

    public ClientEmailId(String clientId, String emailAddressTx) {
        this.clientId = clientId;
        this.emailAddressTx = emailAddressTx;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmailAddressTx() {
        return emailAddressTx;
    }

    public void setEmailAddressTx(String emailAddressTx) {
        this.emailAddressTx = emailAddressTx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientEmailId)) return false;
        ClientEmailId that = (ClientEmailId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(emailAddressTx, that.emailAddressTx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, emailAddressTx);
    }
}
