package admin.service;

import admin.dto.VendorSentToDTO;
import admin.model.VendorSentTo;
import admin.model.Vendor;
import admin.repository.VendorRepository;
import admin.repository.VendorSentToRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class VendorSentToService {

    private final VendorSentToRepository sentToRepository;
    private final VendorRepository vendorRepository;

    public VendorSentToService(VendorSentToRepository sentToRepository, VendorRepository vendorRepository){
        this.sentToRepository = sentToRepository;
        this.vendorRepository = vendorRepository;
    }

    public List<VendorSentToDTO> findBySysPrin(String sysPrin) {

        List<VendorSentTo> sentTo = sentToRepository.findByIdSysPrin(sysPrin);

        Set<String> vendorIds = sentTo.stream()
                .map(v -> v.getId().getVendId())
                .collect(java.util.stream.Collectors.toSet());

        Map<String,String> idToName = vendorRepository.findAllById(vendorIds)
                .stream()
                .collect(java.util.stream.Collectors.toMap(
                        Vendor::getVendId,
                        v -> v.getVendName().trim()
                ));

        return sentTo.stream()
                .map(v -> new VendorSentToDTO(
                        v.getId().getSysPrin(),
                        v.getId().getVendId(),
                        v.getQueForMail(),
                        idToName.getOrDefault(v.getId().getVendId(), "<unknown>")
                ))
                .toList();
    }
}
