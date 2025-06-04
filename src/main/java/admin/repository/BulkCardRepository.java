package admin.repository;

import admin.model.BulkCard;
import admin.model.BulkCardId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BulkCardRepository extends JpaRepository<BulkCard, BulkCardId> {
    List<BulkCard> findByIdCaseNumber(String caseNumber);
    void deleteByIdCaseNumber (String caseNumber);
}
