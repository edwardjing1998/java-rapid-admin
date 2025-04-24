package admin.controller;

import admin.dto.ProductivityWorkDTO;
import admin.service.ProductivityWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/productivity-work")
public class ProductivityWorkController {

    private final ProductivityWorkService service;

    @Autowired
    public ProductivityWorkController(ProductivityWorkService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<ProductivityWorkDTO> getAllProductivityWork() {
        return service.getAllRecords();
    }

    @GetMapping("/all-users")
    public List<ProductivityWorkDTO> getProductivitySummary(
            @RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
            @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {
        return service.getSelectedFieldsByAllUsers(fromDate, toDate);
    }

    @GetMapping("/by-user")
    public List<ProductivityWorkDTO> getRecordsByUserId(
            @RequestParam String userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate
    ) {
        return service.getRecordsByUserId(userId, fromDate, toDate);
    }
}
