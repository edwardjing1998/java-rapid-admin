package admin.service;

import admin.dto.AccountTransactionReportDTO;
import admin.repository.AccountTransactionReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountTransactionReportService {

    private final AccountTransactionReportRepository repository;

    public AccountTransactionReportService(AccountTransactionReportRepository repository) {
        this.repository = repository;
    }

    public List<AccountTransactionReportDTO> getReport(LocalDateTime fromDate, LocalDateTime toDate, String client) {
        if (client == null || client.isBlank()) {
            return repository.findReportForAllClients(fromDate, toDate);
        } else {
            return repository.findReport(fromDate, toDate, client);
        }
    }
}

