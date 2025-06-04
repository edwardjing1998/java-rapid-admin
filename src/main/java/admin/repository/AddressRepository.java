package admin.repository;

import admin.model.AccountTransaction;
import admin.model.Address;
import admin.model.BulkCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    List<BulkCard> findByCaseNumberId(String caseNumberId);
}
