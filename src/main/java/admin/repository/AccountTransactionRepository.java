package admin.repository;

import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import admin.model.Labels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, AccountTransactionId> {
    List<AccountTransaction> findByCaseEntity_CaseNumber(String caseNumber);

    List<AccountTransaction> findByAccount(String account);

    List<AccountTransaction> findByIdCaseNumber(String caseNumber);

    void deleteByAccount(String account);
    void deleteByIdCaseNumber(String caseNumber);
}
