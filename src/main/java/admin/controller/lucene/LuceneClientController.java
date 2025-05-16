package admin.controller.lucene;

import admin.dto.ClientDTO;
import admin.dto.ClientSearchDTO;
import admin.model.Client;
import admin.service.ClientService;
import admin.service.lucene.LuceneClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}