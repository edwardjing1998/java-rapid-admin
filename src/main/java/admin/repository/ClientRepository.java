package admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import admin.model.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    // You can add custom queries if needed, for example:
    // List<Client> findByActiveTrue();
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.sysPrins")
    List<Client> findAllWithSysPrins();

}

