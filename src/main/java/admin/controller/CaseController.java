package admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import admin.dto.CaseDTO;
import admin.service.CaseService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/case")
@CrossOrigin(origins = "http://localhost:3000")
public class CaseController {

    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping("/daily-return-destroy")
    public ResponseEntity<Map<String, List<CaseDTO>>> dailyReturnDestroy() {
        return ResponseEntity.ok(caseService.getCasesByDisposition(Arrays.asList("D", "B", "S")));
    }
    @GetMapping("/inventory-listing")
    public ResponseEntity<Map<String, List<CaseDTO>>> inventoryListing() {
        return ResponseEntity.ok(caseService.getCasesByDisposition(Arrays.asList("R", "H")));
    }
    @GetMapping("/inventory-received")
    public ResponseEntity<Map<String, List<CaseDTO>>> inventoryReceived() {
        return ResponseEntity.ok(caseService.getCasesByDisposition(Arrays.asList("R", "H", "D", "B", "S")));
    }

    @GetMapping("/with-transactions/{caseNumber}")
    public CaseDTO getCaseWithTransactions(@PathVariable String caseNumber) {
        return caseService.getCaseWithTransactions(caseNumber);
    }

    @DeleteMapping("/deletedByAccount/{account}")
    public ResponseEntity<Void> deleteCasesByAccount(@PathVariable String account) {
        caseService.deleteCasesByAccount(account);
        return ResponseEntity.noContent().build();
    }
}
