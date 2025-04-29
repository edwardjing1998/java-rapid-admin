package admin.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ProductivityWorkId implements Serializable {

    private String userId;
    private LocalDateTime fromDate;

    public ProductivityWorkId() {
    }

    public ProductivityWorkId(String userId, LocalDateTime fromDate) {
        this.userId = userId;
        this.fromDate = fromDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductivityWorkId)) return false;
        ProductivityWorkId that = (ProductivityWorkId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(fromDate, that.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fromDate);
    }
}
