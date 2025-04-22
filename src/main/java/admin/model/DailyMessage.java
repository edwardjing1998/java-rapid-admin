package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DAILY_MESSAGES")
public class DailyMessage {

    @Id
    @Column(name = "message_date", nullable = false)
    private LocalDateTime messageDate;

    @Column(name = "message_text", length = 255)
    private String messageText;

    // Constructors
    public DailyMessage() {}

    public DailyMessage(LocalDateTime messageDate, String messageText) {
        this.messageDate = messageDate;
        this.messageText = messageText;
    }

    // Getters and Setters
    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
