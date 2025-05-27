package admin.controller;

import admin.dto.DeletedAccountTransactionDTO;
import admin.model.DeletedAccountTransaction;
import admin.service.DeletedAccountTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deleted-account-transactions")
public class DeletedAccountTransactionController {

    private final DeletedAccountTransactionService service;

    public DeletedAccountTransactionController(DeletedAccountTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeletedAccountTransactionDTO> getAllDeletedAccountTransactions() {
        return service.getAllDeletedAccountTransactions();
    }
}
