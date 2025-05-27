package admin.controller;

import admin.dto.DeletedCaseDTO;
import admin.service.DeletedCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deleted-cases")
@CrossOrigin(origins = "http://localhost:3000")
public class DeletedCaseController {

    private final DeletedCaseService deletedCaseService;

    public DeletedCaseController(DeletedCaseService deletedCaseService) {
        this.deletedCaseService = deletedCaseService;
    }

    @GetMapping("/all")
    public List<DeletedCaseDTO> getAllDeletedCases() {
        return deletedCaseService.getAllDeletedCases();
    }

    @DeleteMapping("/delete-by-account/{account}")
    public String deleteDeletedCasesByAccount(@PathVariable String account) {
        deletedCaseService.deleteDeletedCasesByAccount(account);
        return "Deleted DeletedCase records with account: " + account;
    }
}
