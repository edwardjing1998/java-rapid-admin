package admin.service;

import admin.dto.DailyMessageDTO;
import admin.model.DailyMessage;
import admin.repository.DailyMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyMessageService {

    private final DailyMessageRepository dailyMessageRepository;

    public DailyMessageService(DailyMessageRepository dailyMessageRepository) {
        this.dailyMessageRepository = dailyMessageRepository;
    }

    // Get messages between date range as DTOs
    public List<DailyMessageDTO> getMessagesBetween(LocalDateTime start, LocalDateTime end) {
        return dailyMessageRepository.findByMessageDateBetween(start, end)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert entity to DTO
    private DailyMessageDTO convertToDTO(DailyMessage message) {
        return new DailyMessageDTO(message.getMessageDate(), message.getMessageText());
    }
}
