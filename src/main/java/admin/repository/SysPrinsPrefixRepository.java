package admin.repository;

import admin.model.SysPrinsPrefix;
import admin.model.SysPrinsPrefixId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPrinsPrefixRepository extends JpaRepository<SysPrinsPrefix, SysPrinsPrefixId> {
    List<SysPrinsPrefix> findByIdBillingSp(String billingSp);

}
