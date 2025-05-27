package admin.repository;

import admin.model.DeletedCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedCaseRepository extends JpaRepository<DeletedCase, String> {
    void deleteByAccount(String account);
}
