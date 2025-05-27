package admin.repository;

import admin.model.DeletedTransaction;
import admin.model.DeletedTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedTransactionRepository extends JpaRepository<DeletedTransaction, DeletedTransactionId> {
}
