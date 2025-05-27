package admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import admin.model.Case;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, String> {

    @Query(value = """
    SELECT s.client,
           c.case_number, c.account, c.last_name, c.first_name, c.hm_phone, c.wk_phone,
           c.status, c.num_cards, c.next_date, c.reason, c.disposition,
           c.in_date, c.delivery_id, c.sys_prin, c.out_date, c.cycle,
           c.active, c.in_hour, c.auto_date, c.subreason, c.pi_id, c.account
    FROM CASES c
    JOIN SYS_PRINS s ON c.sys_prin = s.sys_prin
    WHERE c.disposition IN (:dispositions)
    """, nativeQuery = true)
    List<Object[]> fetchCasesByDisposition(@Param("dispositions") List<String> dispositions);

    void deleteByAccount(String account);
}
