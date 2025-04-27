package admin.repository;

import admin.model.ClientReportOption;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientReportOptionRepository extends JpaRepository<ClientReportOption, Long> {
    List<ClientReportOption> findById_ClientId(String clientId);
}
