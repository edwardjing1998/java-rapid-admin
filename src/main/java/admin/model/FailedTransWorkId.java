package admin.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FailedTransWorkId implements Serializable {

    private String caseNumber;
    private String piId;
    private String account;

    public FailedTransWorkId() {}

    public FailedTransWorkId(String caseNumber, String piId, String account) {
        this.caseNumber = caseNumber;
        this.piId = piId;
        this.account = account;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FailedTransWorkId)) return false;
        FailedTransWorkId that = (FailedTransWorkId) o;
        return Objects.equals(caseNumber, that.caseNumber) &&
                Objects.equals(piId, that.piId) &&
                Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, piId, account);
    }
}
