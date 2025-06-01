package admin.repository;

import admin.model.VendorSentTo;
import admin.model.VendorSentToId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface VendorSentToRepository  extends JpaRepository<VendorSentTo, VendorSentToId> {

    List<VendorSentTo> findByIdSysPrin(String sysPrin);
    List<VendorSentTo> findByIdSysPrinIn(Collection<String> sysPrinIds);

}
