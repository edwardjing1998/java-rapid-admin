package admin.controller;

import admin.dto.DailyMessageDTO;
import admin.service.DailyMessageService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/daily-messages")
public class DailyMessageController {

    private final DailyMessageService dailyMessageService;

    public DailyMessageController(DailyMessageService dailyMessageService) {
        this.dailyMessageService = dailyMessageService;
    }

    @GetMapping("/between")
    public List<DailyMessageDTO> getMessagesBetween(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return dailyMessageService.getMessagesBetween(start, end);
    }
}
