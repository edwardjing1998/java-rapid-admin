package admin.controller;

import admin.dto.LabelsDTO;
import admin.service.LabelsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LabelsController {

    private final LabelsService service;

    public LabelsController(LabelsService service) {
        this.service = service;
    }

    @GetMapping("/labels")
    public ResponseEntity<List<LabelsDTO>> getAllLabels() {
        List<LabelsDTO> list = service.getAllLabels();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/print/")
    public List<LabelsDTO> getLabelsByType() {
        return service.findByType("PRINT");
    }
}
