package admin.config.data;

import admin.model.DailyMessage;
import admin.repository.DailyMessageRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("local")
public class DailyMessageDataGenerator {

    private final DailyMessageRepository dailyMessageRepository;

    public DailyMessageDataGenerator(DailyMessageRepository dailyMessageRepository) {
        this.dailyMessageRepository = dailyMessageRepository;
    }

    public void generateDailyMessages() {
        List<DailyMessage> messages = new ArrayList<>();

        LocalDateTime today = LocalDateTime.now().with(LocalTime.of(9, 0)); // e.g. 9 AM daily
        for (int i = 1; i <= 30; i++) {
            LocalDateTime messageDate = today.minusDays(i);
            String messageText = "Daily message for " + messageDate.toLocalDate();

            DailyMessage message = new DailyMessage(messageDate, messageText);
            messages.add(message);
        }

        dailyMessageRepository.saveAll(messages);
    }
}
