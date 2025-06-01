package admin.controller;

import admin.dto.projection.VendorTransferInformation;
import admin.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin(origins = "http://localhost:3000")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService){
        this.vendorService = vendorService;
    }

    @GetMapping
    public List<VendorTransferInformation> getByFileIo(@RequestParam("fileIo") String fileIo) {
        return vendorService.findActiveByFileIo(fileIo);
    }
}
