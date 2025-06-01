package admin.repository;

import admin.dto.projection.VendorTransferInformation;
import admin.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

    @Query("""
           select v.vendId           as vendId,
                  v.vendName          as vendName,
                  v.vendReceiverCode      as vendReceiverCode,
                  v.fileServerName as fileServerName,
                  v.fileServerIp  as fileServerIp
             from Vendor v
            where v.active = true
              and v.fileIo = :io
           """)
    List<VendorTransferInformation> findActiveByFileIo(@Param("io") String fileIo);
}
