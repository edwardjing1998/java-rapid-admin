package admin.service;

import admin.model.ClientEmail;
import admin.repository.ClientEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientEmailService {

    private final ClientEmailRepository clientEmailRepository;

    public ClientEmailService(ClientEmailRepository clientEmailRepository) {
        this.clientEmailRepository = clientEmailRepository;
    }

    public List<ClientEmail> getEmailsByClientId(String clientId) {
        return clientEmailRepository.findByIdClientId(clientId);
    }

    public ClientEmail saveClientEmail(ClientEmail email) {
        if (email.getId() == null) {
            admin.model.ClientEmailId id = new admin.model.ClientEmailId();
            id.setClientId(email.getId().getClientId());
            id.setEmailAddressTx(email.getId().getEmailAddressTx());
            email.setId(id);
        }
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

