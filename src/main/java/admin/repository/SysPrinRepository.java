package admin.repository;

import admin.model.SysPrin;
import admin.model.SysPrinId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPrinRepository extends JpaRepository<SysPrin, SysPrinId> {

    // Find all SysPrins by a specific client
    List<SysPrin> findByIdClient(String client);

    // Optional: Find all SysPrins for multiple clients
    List<SysPrin> findByIdClientIn(List<String> clients);
}
