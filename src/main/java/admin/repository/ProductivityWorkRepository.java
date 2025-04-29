package admin.repository;

import admin.dto.BulkDestSummaryDTO;
import admin.model.ProductivityWork;
import admin.model.ProductivityWorkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductivityWorkRepository extends JpaRepository<ProductivityWork, ProductivityWorkId> {

    @Query("""
        SELECT p FROM ProductivityWork p
        WHERE 
            COALESCE(p.mailedCount, 0) + COALESCE(p.returnedCount, 0) + COALESCE(p.destroyedCount, 0) +
            COALESCE(p.researchCount, 0) + COALESCE(p.holdCount, 0) + COALESCE(p.paymentCount, 0) +
            COALESCE(p.specialCount, 0) + COALESCE(p.bulkRetCount, 0) + COALESCE(p.bulkDestCount, 0) +
            COALESCE(p.privateLabelCount, 0) > 0
        AND p.id.fromDate >= :fromDate
        AND p.id.fromDate <= :toDate
        ORDER BY p.id.userId, p.id.fromDate
    """)
    List<ProductivityWork> findAllValidProductivityWork(LocalDateTime fromDate, LocalDateTime toDate);

    @Query("""
        SELECT p FROM ProductivityWork p
        WHERE 
            COALESCE(p.mailedCount, 0) + COALESCE(p.returnedCount, 0) + COALESCE(p.destroyedCount, 0) +
            COALESCE(p.researchCount, 0) + COALESCE(p.holdCount, 0) + COALESCE(p.paymentCount, 0) +
            COALESCE(p.specialCount, 0) + COALESCE(p.bulkRetCount, 0) + COALESCE(p.bulkDestCount, 0) +
            COALESCE(p.privateLabelCount, 0) > 0
        AND p.id.userId = :userId
        AND p.id.fromDate >= :fromDate
        AND p.id.fromDate <= :toDate
        ORDER BY p.id.userId, p.id.fromDate
    """)
    List<ProductivityWork> findValidProductivityWorkByUser(String userId, LocalDateTime fromDate, LocalDateTime toDate);

    @Query("SELECT new admin.dto.BulkDestSummaryDTO(SUM(p.bulkDestCount), SUM(p.bulkDestCards)) FROM ProductivityWork p")
    BulkDestSummaryDTO getBulkDestSummary();
}
