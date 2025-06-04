package admin.repository;

import admin.model.FailedTransaction;
import admin.model.Labels;
import admin.model.LabelsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelsRepository extends JpaRepository<Labels, LabelsId> {
    List<Labels> findByIdType(String type);
    List<Labels> findByIdCaseNumber(String caseNumber);
    void deleteAllByIdCaseNumber(String caseNumber);
}
