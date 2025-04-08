package admin.repository;

import admin.model.SysPrinsPrefix;
import org.springframework.data.jpa.repository.JpaRepository;
import admin.model.ClientReportOption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientReportOptionRepository extends JpaRepository<ClientReportOption, Long> {
    @Query("SELECT s FROM SysPrinsPrefix s WHERE s.client.client = :clientId")
    List<SysPrinsPrefix> findByClientId(@Param("clientId") String clientId);
}

