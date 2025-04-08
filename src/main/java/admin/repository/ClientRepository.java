package admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import admin.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
    // You can add custom queries if needed, for example:
    // List<Client> findByActiveTrue();
}

