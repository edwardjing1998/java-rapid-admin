package admin.dto;

import java.time.LocalDateTime;

public class DailyMessageDTO {

    private LocalDateTime messageDate;
    private String messageText;

    public DailyMessageDTO() {
    }

    public DailyMessageDTO(LocalDateTime messageDate, String messageText) {
        this.messageDate = messageDate;
        this.messageText = messageText;
    }

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
