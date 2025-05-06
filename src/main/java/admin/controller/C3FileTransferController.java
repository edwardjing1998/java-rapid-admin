package admin.controller;

import admin.dto.C3FileTransferDTO;
import admin.service.C3FileTransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/c3filetransfers")
public class C3FileTransferController {

    private final C3FileTransferService service;

    public C3FileTransferController(C3FileTransferService service) {
        this.service = service;
    }

    @GetMapping
    public List<C3FileTransferDTO> getAllTransfers() {
        return service.getAllTransfers();
    }
}
