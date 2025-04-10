// SysPrinsPrefixController.java
package admin.controller;

import admin.dto.DeletePrefixRequest;
import admin.dto.SysPrinsPrefixRequest;
import admin.model.SysPrinsPrefix;
import admin.service.SysPrinsPrefixService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prefixes")
@CrossOrigin(origins = "http://localhost:3000")
public class SysPrinsPrefixController {

    private final SysPrinsPrefixService service;

    public SysPrinsPrefixController(SysPrinsPrefixService service) {
        this.service = service;
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteByBillingSpAndPrefix(@RequestBody DeletePrefixRequest request) {
        service.deleteByBillingSpAndPrefix(request.getBillingSp(), request.getPrefix());
        return ResponseEntity.noContent().build(); // HTTP 204
    }

    @PostMapping("/add")
    public SysPrinsPrefix addPrefix(@RequestBody SysPrinsPrefixRequest prefix) {
        return service.save(prefix);
    }
}
