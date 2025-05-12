package admin.controller;

import admin.dto.AccountTransactionReportDTO;
import admin.service.AccountTransactionReportService;
import admin.service.SysPrinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/account-transaction-report")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountTransactionReportController {

    private static final Logger logger = LoggerFactory.getLogger(AccountTransactionReportController.class);

    private final AccountTransactionReportService reportService;

    public AccountTransactionReportController(AccountTransactionReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<AccountTransactionReportDTO> getReport(
            @RequestParam("fromDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime fromDate,
            @RequestParam("toDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS") LocalDateTime toDate,
            @RequestParam("client") String client
    ) {
        logger.info("AccountTransactionReportDTO::Client {}", client);
        List<AccountTransactionReportDTO> reports = reportService.getReport(fromDate, toDate, client);
        logger.info("AccountTransactionReportDTO::Reports Size {}", reports.size());
        return reports;
    }
}
