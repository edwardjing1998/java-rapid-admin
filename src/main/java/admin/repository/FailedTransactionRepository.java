package admin.repository;

import admin.model.FailedTransaction;
import admin.model.FailedTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailedTransactionRepository extends JpaRepository<FailedTransaction, FailedTransactionId> {
    List<FailedTransaction> findByIdCaseNumber(String caseNumber);
    void deleteByIdCaseNumber(String caseNumber);
}
