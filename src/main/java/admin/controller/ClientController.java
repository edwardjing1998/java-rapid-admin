package admin.controller;

import admin.dto.ClientDTO;
import admin.model.Client;
import admin.service.ClientService;
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

    @GetMapping("/clients")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClientsWithDetails();
    }

    @PostMapping("/client/save")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
}
