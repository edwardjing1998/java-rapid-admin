package admin.repository;

import admin.model.ClientEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientEmailRepository extends JpaRepository<ClientEmail, Long> {

    // Find all emails by Client_ID
    List<ClientEmail> findByClientId(String clientId);

    // Optional: Find by Report ID if needed
    List<ClientEmail> findByReportId(Long reportId);

    // Optional: Get only active emails
    List<ClientEmail> findByClientIdAndActiveFlag(String clientId, Boolean activeFlag);
}
