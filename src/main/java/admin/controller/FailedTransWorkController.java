package admin.controller;

import admin.dto.FailedTransSummaryDTO;
import admin.dto.FailedTransWorkDTO;
import admin.model.FailedTransWork;
import admin.service.FailedTransWorkService;
import admin.service.FailedTransWorkSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/failed-trans-work")
@CrossOrigin(origins = "http://localhost:3000")
public class FailedTransWorkController {

    private final FailedTransWorkService service;

    private final FailedTransWorkSummaryService failedTransWorkSummaryService;

    public FailedTransWorkController(FailedTransWorkService service, FailedTransWorkSummaryService failedTransWorkSummaryService) {
        this.service = service;
        this.failedTransWorkSummaryService = failedTransWorkSummaryService;
    }

    @PostMapping("/save")
    public FailedTransWork create(@RequestBody FailedTransWorkDTO dto) {
        return service.save(dto);
    }

    @GetMapping("/all")
    public List<FailedTransWorkDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/summary")
    public List<FailedTransSummaryDTO> getFailedTransSummary() {
        return failedTransWorkSummaryService.getFailedTransSummary();
    }
}
