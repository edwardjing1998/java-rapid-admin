package admin.repository;

import admin.model.FailedTransWork;
import admin.model.FailedTransWorkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailedTransWorkRepository extends JpaRepository<FailedTransWork, FailedTransWorkId> {
}
