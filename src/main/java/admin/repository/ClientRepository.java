package admin.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import admin.model.Client;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    @Query("SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.sysPrins")
    List<Client> findAllWithSysPrins();

    @Query("SELECT c FROM Client c WHERE c.client IS NOT NULL AND c.client <> ''")
    List<Client> findAllValidClients();

    @Query("SELECT c FROM Client c WHERE c.client IS NOT NULL AND c.client <> ''")
    Page<Client> getClientsWithPaginations(Pageable pageable);

    @Query("SELECT c FROM Client c WHERE c.client IS NOT NULL AND c.client <> ''")
    List<Client> getAllClients();

    // ✅ Native SQL query: select * from CLIENTS
    @Query(value = "SELECT CLIENT, NAME FROM CLIENTS", nativeQuery = true)
    List<Object[]> findAllClientNamesNative();
}

