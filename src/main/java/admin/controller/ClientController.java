package admin.controller;

import admin.dto.ClientDTO;
import admin.dto.ClientSearchDTO;
import admin.model.Client;
import admin.service.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientService clientService;

    // Constructor for dependency injection
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients-paging")
    public List<ClientDTO> getClientsWithPaginations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        logger.info("the page input {} in  ClientController::getClientsWithPaginations", page);
        logger.info("the page size {} in  ClientController::getClientsWithPaginations", size);
        Pageable pageable = PageRequest.of(page, size);
        return clientService.getClientsWithPaginations(pageable);
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/client/save")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/client-search")
    public List<ClientSearchDTO> getSimpleClients() {
        return clientService.getClientSearch();
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/client/wildcard")
    public List<ClientDTO> searchClientsDbFull(@RequestParam String keyword) {
        logger.info("the keyword input {} in  ClientController::searchClientsDbFull", keyword);
        return clientService.searchClientsByWildcard(trimLastDigit(keyword));
    }

   private String trimLastDigit(String keyword){
       String trimmed = null;
       if (keyword != null && keyword.length() > 0) {
           trimmed = keyword.substring(0, keyword.length() - 1); // remove last char
           logger.info("the processed keyword  {} in  ClientController::searchClientsDbFull", trimmed);
       }
     return trimmed;
    }
}
