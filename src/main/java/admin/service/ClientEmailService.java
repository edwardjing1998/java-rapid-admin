package admin.service;

import admin.model.Client;
import admin.model.ClientEmail;
import admin.model.ClientEmailId;
import admin.repository.ClientEmailRepository;
import admin.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientEmailService {

    private final ClientEmailRepository clientEmailRepository;

    private final ClientRepository clientRepository; // ✅ Add clientRepository


    public ClientEmailService(ClientEmailRepository clientEmailRepository,
                              ClientRepository clientRepository) { // ✅ Add in constructor
        this.clientEmailRepository = clientEmailRepository;
        this.clientRepository = clientRepository;
    }

    public List<ClientEmail> getEmailsByClientId(String clientId) {
        return clientEmailRepository.findByIdClientId(clientId);
    }

    public ClientEmail saveClientEmail(ClientEmail email) {
        ClientEmailId id = email.getId();
        if (id == null) {
            id = new ClientEmailId();
            id.setClientId(email.getClient().getClient());
            id.setEmailAddressTx(email.getId().getEmailAddressTx());
            email.setId(id);
        }

        Client client = clientRepository.findById(id.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found: "));

        email.setClient(client); // 🔐 Required for @ManyToOne
        email.getId().setClientId(client.getClient()); // Ensure FK is in ID too

        return clientEmailRepository.save(email);
    }



    @Transactional
    public boolean deleteByClientIdAndEmailAddress(String clientId, String emailAddress) {
        return clientEmailRepository.findByIdClientIdAndIdEmailAddressTx(clientId, emailAddress)
                .map(email -> {
                    clientEmailRepository.deleteByIdClientIdAndIdEmailAddressTx(clientId, emailAddress);
                    return true;
                })
                .orElse(false);
    }
}

