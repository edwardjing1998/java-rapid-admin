package admin.repository;

import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, AccountTransactionId> {
    List<AccountTransaction> findByCaseEntity_CaseNumber(String caseNumber); // ✅ uses the @ManyToOne relationship

}
