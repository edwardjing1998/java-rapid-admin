package admin.repository;

import admin.model.ClientEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ClientEmailRepository extends JpaRepository<ClientEmail, Long> {
    List<ClientEmail> findByClientId(String clientId);
    void deleteByClientIdAndEmailAddress(String clientId, String emailAddress);
    Optional<ClientEmail> findByClientIdAndEmailAddress(String clientId, String emailAddress);
}
