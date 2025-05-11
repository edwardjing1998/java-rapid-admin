package admin.controller;

import admin.dto.C3FileTransferDTO;
import admin.model.C3FileTransfer;
import admin.service.C3FileTransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/c3-filetransfer")
@CrossOrigin(origins = "http://localhost:3000")
public class C3FileTransferController {

    private static final Logger logger = LoggerFactory.getLogger(C3FileTransferController.class);

    private final C3FileTransferService c3FileTransferService;

    // Constructor for dependency injection
    public C3FileTransferController(C3FileTransferService c3FileTransferService) {
        this.c3FileTransferService = c3FileTransferService;
    }

    @GetMapping
    public List<C3FileTransferDTO> getAllTransfers() {
        return c3FileTransferService.getAllTransfers();
    }

    @PostMapping
    public ResponseEntity<C3FileTransfer> createC3filetransferist(@RequestBody C3FileTransfer c3FileTransfer) {
        if(c3FileTransfer != null) {
            logger.info("Json Data {} in createC3filetransferist ", c3FileTransfer.toString());
            C3FileTransfer c3FileTransferObj = c3FileTransferService.createC3fileTransfer(c3FileTransfer);
            return ResponseEntity.status(HttpStatus.CREATED).body(c3FileTransferObj);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{filetrnsId}")
    public ResponseEntity<String> deleteC3fileTransferList(@PathVariable Integer filetrnsId) {

        if(filetrnsId != null) {
            boolean deleted = c3FileTransferService.deleteC3fileTransferList(filetrnsId);

            if (deleted) {
                return ResponseEntity.ok("C3 file transfer List deleted successfully.");
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<C3FileTransfer> updateC3fileTransfer(@RequestBody C3FileTransferDTO c3FileTransferDTO) {

        if (c3FileTransferDTO == null || c3FileTransferDTO.getFileTransId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<C3FileTransfer> updated = c3FileTransferService.updateC3fileTransferList(c3FileTransferDTO);

        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{fileTransId}")
    public ResponseEntity<C3FileTransferDTO> getC3fileTransferById(@PathVariable Integer fileTransId) {
        Optional<C3FileTransferDTO> result = c3FileTransferService.getC3fileTransferById(fileTransId);

        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}