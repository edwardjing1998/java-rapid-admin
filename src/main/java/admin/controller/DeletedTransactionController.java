package admin.controller;

import admin.dto.DeletedTransactionDTO;
import admin.service.DeletedTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deleted-transactions")
public class DeletedTransactionController {

    private final DeletedTransactionService service;

    public DeletedTransactionController(DeletedTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeletedTransactionDTO> getAllDeletedTransactions() {
        return service.getAllDeletedTransactions();
    }
}
