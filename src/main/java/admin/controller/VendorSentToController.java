package admin.controller;

import admin.dto.VendorSentToDTO;
import admin.service.VendorSentToService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vendor-sent-to")
public class VendorSentToController {

    private final VendorSentToService service;

    public VendorSentToController(VendorSentToService service){
        this.service = service;
    }
    @GetMapping("/{sysPrin}")
    public List<VendorSentToDTO> findBySysPrin(@PathVariable String sysPrin) {
        return service.findBySysPrin(sysPrin.trim());
    }
}
