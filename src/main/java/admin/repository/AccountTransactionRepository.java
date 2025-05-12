package admin.repository;

import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, AccountTransactionId> {
}
