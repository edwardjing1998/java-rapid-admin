package admin.repository;

import admin.model.SysPrinsPrefix;
import admin.model.SysPrinsPrefixId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SysPrinsPrefixRepository extends JpaRepository<SysPrinsPrefix, SysPrinsPrefixId> {

    List<SysPrinsPrefix> findByIdBillingSp(String billingSp);

    @Modifying
    @Transactional
    @Query("UPDATE SysPrinsPrefix p SET p.id.atmCashRule = :atmCashRule WHERE p.id.billingSp = :billingSp AND p.id.prefix = :prefix")
    int updateAtmCashRuleByBillingSpAndPrefix(
            @Param("billingSp") String billingSp,
            @Param("prefix") String prefix,
            @Param("atmCashRule") String atmCashRule
    );
}
