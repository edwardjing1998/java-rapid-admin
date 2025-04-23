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
        return clientEmailRepository.findByClientId(clientId);
    }

    public ClientEmail saveClientEmail(ClientEmail email) {
        LocalDateTime now = LocalDateTime.now();
        email.setCreatedAt(now);
        email.setUpdatedAt(now);
        return clientEmailRepository.save(email);
    }
    @Transactional
    public boolean deleteByClientIdAndEmailAddress(String clientId, String emailAddress) {
        return clientEmailRepository.findByClientIdAndEmailAddress(clientId, emailAddress)
                .map(email -> {
                    clientEmailRepository.deleteByClientIdAndEmailAddress(clientId, emailAddress);
                    return true;
                })
                .orElse(false);
    }
}
