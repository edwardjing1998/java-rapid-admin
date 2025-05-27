package admin.repository;

import admin.model.DeletedAccountTransaction;
import admin.model.DeletedAccountTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedAccountTransactionRepository extends JpaRepository<DeletedAccountTransaction, DeletedAccountTransactionId> {
}
