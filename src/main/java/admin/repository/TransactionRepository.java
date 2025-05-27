package admin.repository;

import admin.model.Transaction;
import admin.model.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
    List<Transaction> findByIdCaseNumber(String caseNumber);
    void deleteByIdCaseNumber(String caseNumber);
}
