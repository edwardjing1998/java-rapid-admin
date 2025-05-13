package admin.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FailedTransSummaryRepositoryImpl implements FailedTransSummaryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tuple> findSummaryByType() {
        String sql = """
            SELECT 
                ft.case_number AS caseNumber, 
                at.pi_id AS piId, 
                ft.date_time AS dateTime, 
                at.account AS account, 
                ft.command_line AS commandLine,
                ft.retry_count AS retryCount
            FROM 
                failed_trans ft
            JOIN
                account_trans at ON ft.case_number = at.case_number
            WHERE
                ft.type = 1
        """;

        Query query = entityManager
                .createNativeQuery(sql, Tuple.class);  // 🔹 Tell JPA to map rows to Tuple

        return query.getResultList();
    }
}
