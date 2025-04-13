package admin.repository;

import admin.model.AdminQueryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminQueryListRepository extends JpaRepository<AdminQueryList, Long> {

    // Custom query: Get all where report_by_client_flag = 1
    @Query("SELECT a FROM AdminQueryList a WHERE a.reportByClientFlag = 1")
    List<AdminQueryList> findByReportByClientFlagIsOne();

    // Or: derived query method (optional)
    List<AdminQueryList> findByReportByClientFlag(Integer reportByClientFlag);
}
