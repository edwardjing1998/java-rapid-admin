package admin.controller;

import admin.model.ClientEmail;
import admin.service.ClientEmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client-email")
@CrossOrigin(origins = "*")
public class ClientEmailController {

    private final ClientEmailService clientEmailService;

    public ClientEmailController(ClientEmailService clientEmailService) {
        this.clientEmailService = clientEmailService;
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<ClientEmail>> getEmailsByClient(@PathVariable String clientId) {
        return ResponseEntity.ok(clientEmailService.getEmailsByClientId(clientId));
    }

    @PostMapping("/add")
    public ResponseEntity<ClientEmail> addClientEmail(@RequestBody ClientEmail email) {
        ClientEmail saved = clientEmailService.saveClientEmail(email);
        return ResponseEntity.ok(saved);
    }
}
