package admin.controller;

import admin.dto.ClientDTO;
import admin.model.Client;
import admin.service.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    private final ClientService clientService;

    // Constructor for dependency injection
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients-paging")
    public List<ClientDTO> getClientsWithPaginations(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000") int size
    ) {
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
}
