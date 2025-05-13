package admin.controller;

import admin.service.FailedTransService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/failed-trans")
public class FailedTransController {

    private final FailedTransService service;

    public FailedTransController(FailedTransService service) {
        this.service = service;
    }

    @DeleteMapping("/all")
    public String deleteAllFailedTransactions() {
        service.deleteAllFailedTransactions();
        return "All FAILED_TRANS records deleted.";
    }
}
