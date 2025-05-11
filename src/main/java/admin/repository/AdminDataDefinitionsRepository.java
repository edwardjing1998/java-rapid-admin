package admin.repository;

import admin.model.AdminDataDefinitionsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDataDefinitionsRepository extends JpaRepository<AdminDataDefinitionsList, Integer> {

}