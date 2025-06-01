package admin.service;

import admin.dto.projection.VendorTransferInformation;
import admin.model.Vendor;
import admin.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }
    public Vendor save(Vendor v)           { return vendorRepository.save(v); }
    public List<Vendor> saveAll(List<Vendor> list) { return vendorRepository.saveAll(list); }

    public List<VendorTransferInformation> findActiveByFileIo(String fileIo) {
        return vendorRepository.findActiveByFileIo(fileIo.trim());
    }
}
