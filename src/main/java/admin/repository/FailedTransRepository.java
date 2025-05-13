package admin.repository;

import admin.model.FailedTrans;
import admin.model.FailedTransId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailedTransRepository extends JpaRepository<FailedTrans, FailedTransId> {
    // JpaRepository already provides a deleteAll() method
}
