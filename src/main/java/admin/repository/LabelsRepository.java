package admin.repository;

import admin.model.Labels;
import admin.model.LabelsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelsRepository extends JpaRepository<Labels, LabelsId> {
    // Primary key is text1 (String)
    List<Labels> findByIdType(String type);
}
