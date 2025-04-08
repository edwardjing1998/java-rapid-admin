package admin.service;

import admin.dto.ClientDTO;
import admin.model.Client;
import admin.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    // Manual constructor
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClientsWithDetails() {
        return clientRepository.findAll().stream().map(client -> {
            ClientDTO dto = new ClientDTO();
            dto.setClient(client.getClient());
            dto.setName(client.getName());
            dto.setAddr(client.getAddr());
            dto.setCity(client.getCity());
            dto.setState(client.getState());
            dto.setZip(client.getZip());
            dto.setContact(client.getContact());
            dto.setPhone(client.getPhone());
            dto.setActive(client.getActive());
            dto.setReportOptions(client.getReportOptions());
            dto.setSysPrinsPrefixes(client.getSysPrinsPrefixes());
            return dto;
        }).collect(Collectors.toList());
    }
}
