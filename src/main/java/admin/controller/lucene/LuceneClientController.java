package admin.controller.lucene;

import admin.dto.ClientDTO;
import admin.dto.ClientSearchDTO;
import admin.model.Client;
import admin.service.ClientService;
import admin.service.lucene.LuceneClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LuceneClientController {

    private final LuceneClientService clientService;

    // Constructor for dependency injection
    public LuceneClientController(LuceneClientService clientService) {
        this.clientService = clientService;
    }

    // STEP 4: Update Controller method
    @GetMapping("/client-autocomplete")
    public List<ClientSearchDTO> searchClients(@RequestParam String keyword) throws Exception {
        return clientService.getClientSearch(keyword);
    }

    @GetMapping("/api/client-autocomplete")
    public ResponseEntity<List<ClientSearchDTO>> autocomplete(@RequestParam String keyword) {
        try {
            List<ClientSearchDTO> results = clientService.getClientSearch(keyword);
            if (results == null || results.isEmpty()) {
                // Return a fallback DTO when no match is found
                return ResponseEntity.ok(
                        List.of(new ClientSearchDTO(keyword, "client not found"))
                );
            }
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of(new ClientSearchDTO("error", e.getMessage())));
        }
    }
}