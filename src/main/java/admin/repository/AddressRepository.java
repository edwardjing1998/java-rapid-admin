package admin.repository;

import admin.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    // case_number_id is the primary key, hence String as the ID type
}
