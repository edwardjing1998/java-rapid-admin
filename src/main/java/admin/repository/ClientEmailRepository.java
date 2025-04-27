package admin.repository;

import admin.model.ClientEmail;
import admin.model.ClientEmailId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientEmailRepository extends JpaRepository<ClientEmail, ClientEmailId> {
    List<ClientEmail> findByIdClientId(String clientId);
    void deleteByIdClientIdAndIdEmailAddressTx(String clientId, String emailAddressTx);
    Optional<ClientEmail> findByIdClientIdAndIdEmailAddressTx(String clientId, String emailAddressTx);
}
