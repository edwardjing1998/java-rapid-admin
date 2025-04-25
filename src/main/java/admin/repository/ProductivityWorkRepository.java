package admin.repository;

import admin.dto.BulkDestSummaryDTO;
import admin.model.ProductivityWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductivityWorkRepository extends JpaRepository<ProductivityWork, Long> {

    @Query("""
    SELECT 
        p.userId,
        p.userName,
        p.fromDate,
        p.mailedCount,
        p.returnedCount,
        p.destroyedCount,
        p.researchCount,
        p.paymentCount,
        p.specialCount,
        p.holdCount,
        p.bulkDestCount,
        p.bulkRetCount,
        p.privateLabelCount,
        p.mailedCards,
        p.returnedCards,
        p.destroyedCards,
        p.researchCards,
        p.holdCards,
        p.paymentCards,
        p.specialCards,
        p.bulkDestCards,
        p.bulkRetCards,
        p.privateLabelCards
    FROM ProductivityWork p
    WHERE 
        COALESCE(p.mailedCount, 0) + COALESCE(p.returnedCount, 0) + COALESCE(p.destroyedCount, 0) +
        COALESCE(p.researchCount, 0) + COALESCE(p.holdCount, 0) + COALESCE(p.paymentCount, 0) +
        COALESCE(p.specialCount, 0) + COALESCE(p.bulkRetCount, 0) + COALESCE(p.bulkDestCount, 0) +
        COALESCE(p.privateLabelCount, 0) > 0
    AND p.fromDate >= :fromDate
    AND p.fromDate <= :toDate
    ORDER BY p.userId, p.fromDate
""")
    List<Object[]> findSelectedFieldsByAllUsers(LocalDateTime fromDate, LocalDateTime toDate);

    @Query("""
    SELECT 
       p.userId,
        p.userName,
        p.fromDate,
        p.mailedCount,
        p.returnedCount,
        p.destroyedCount,
        p.researchCount,
        p.paymentCount,
        p.specialCount,
        p.holdCount,
        p.bulkDestCount,
        p.bulkRetCount,
        p.privateLabelCount,
        p.mailedCards,
        p.returnedCards,
        p.destroyedCards,
        p.researchCards,
        p.holdCards,
        p.paymentCards,
        p.specialCards,
        p.bulkDestCards,
        p.bulkRetCards,
        p.privateLabelCards
    FROM ProductivityWork p
    WHERE 
        COALESCE(p.mailedCount, 0) + COALESCE(p.returnedCount, 0) + COALESCE(p.destroyedCount, 0) +
        COALESCE(p.researchCount, 0) + COALESCE(p.holdCount, 0) + COALESCE(p.paymentCount, 0) +
        COALESCE(p.specialCount, 0) + COALESCE(p.bulkRetCount, 0) + COALESCE(p.bulkDestCount, 0) +
        COALESCE(p.privateLabelCount, 0) > 0
    AND p.userId = :userId
    AND p.fromDate >= :fromDate
    AND p.fromDate <= :toDate
    ORDER BY p.userId, p.fromDate
""")
    List<Object[]> findSelectedFieldsByUserId(String userId, LocalDateTime fromDate, LocalDateTime toDate);

    @Query("SELECT new admin.dto.BulkDestSummaryDTO(SUM(p.bulkDestCount), SUM(p.bulkDestCards)) FROM ProductivityWork p")
    BulkDestSummaryDTO getBulkDestSummary();


}
