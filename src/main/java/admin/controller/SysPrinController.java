package admin.controller;

import admin.dto.SysPrinDTO;
import admin.service.SysPrinService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sysprins")
@CrossOrigin(origins = "http://localhost:3000")
public class SysPrinController {

    private final SysPrinService sysPrinService;

    public SysPrinController(SysPrinService sysPrinService) {
        this.sysPrinService = sysPrinService;
    }

    // POST: Save sysprins for a client
    @PostMapping("/{clientId}")
    public ResponseEntity<String> saveSysPrinsForClient(
            @PathVariable String clientId,
            @RequestBody List<SysPrinDTO> sysPrinDTOList) {

        try {
            sysPrinService.saveSysPrinsForClient(clientId, sysPrinDTOList);
            return ResponseEntity.ok("SysPrins saved successfully for client: " + clientId);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error saving SysPrins for client: " + clientId + " - " + e.getMessage());
        }
    }
}
