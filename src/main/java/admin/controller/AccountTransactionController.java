package admin.controller;

import admin.dto.AccountTransactionDTO;
import admin.service.AccountTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-transactions")
public class AccountTransactionController {

    private final AccountTransactionService service;

    public AccountTransactionController(AccountTransactionService service) {
        this.service = service;
    }

    @DeleteMapping("/by-account/{account}")
    public void deleteByAccount(@PathVariable String account) {
        service.deleteByAccount(account);
    }

    @GetMapping("/all")
    public List<AccountTransactionDTO> getAllAccountTransactions() {
        return service.getAllAccountTransactions();
    }
}
