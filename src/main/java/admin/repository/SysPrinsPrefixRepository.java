package admin.repository;

import admin.model.SysPrinsPrefix;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysPrinsPrefixRepository extends JpaRepository<SysPrinsPrefix, Long> {
    List<SysPrinsPrefix> findByBillingSp(String billingSp);
    void deleteByBillingSpAndPrefix(String billingSp, String prefix); // ✅ add this
}
