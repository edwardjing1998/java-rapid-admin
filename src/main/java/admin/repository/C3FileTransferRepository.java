package admin.repository;

import admin.model.C3FileTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface C3FileTransferRepository extends JpaRepository<C3FileTransfer, Integer> {
}
