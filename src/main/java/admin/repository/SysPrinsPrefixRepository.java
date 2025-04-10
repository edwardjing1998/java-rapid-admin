package admin.repository;

import admin.model.SysPrinsPrefix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysPrinsPrefixRepository extends JpaRepository<SysPrinsPrefix, Long> {

    List<SysPrinsPrefix> findByBillingSp(String billingSp);

}