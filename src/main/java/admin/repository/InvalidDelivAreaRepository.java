package admin.repository;

import admin.model.InvalidDelivArea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InvalidDelivAreaRepository extends JpaRepository<InvalidDelivArea, Long> {
    List<InvalidDelivArea> findByIdSysPrin(String sysPrin);
    List<InvalidDelivArea> findByIdSysPrinIn(List<String> sysPrins);



}
