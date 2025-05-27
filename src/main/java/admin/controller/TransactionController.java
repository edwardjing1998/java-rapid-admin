package admin.controller;

import admin.dto.TransactionDTO;
import admin.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @DeleteMapping("/all")
    public String deleteAllFailedTransactions() {
        service.deleteAllFailedTransactions();
        return "All FAILED_TRANS records deleted.";
    }

    // Query by account number
    @GetMapping("/byCaseNumber/{caseNumber}")
    public List<TransactionDTO> getTransactionsByAccountNumber(@PathVariable String caseNumber) {
        return service.getTransactionsByCaseNumber(caseNumber);
    }

    // Delete by account number
    @DeleteMapping("/caseNumber/{caseNumber}")
    public void deleteTransactionsByAccountNumber(@PathVariable String caseNumber) {
        service.deleteTransactionsByCaseNumber(caseNumber);
    }

    @GetMapping("all")
    public List<TransactionDTO> getAllTransactions() {
        return service.getAllTransactions();
    }

}
