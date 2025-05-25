package admin.controller;

import admin.dto.RobotLabelsDTO;
import admin.service.RobotLabelsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Adjust as needed
public class RobotLabelsController {

    private final RobotLabelsService service;

    public RobotLabelsController(RobotLabelsService service) {
        this.service = service;
    }

    @GetMapping("/robot-labels")
    public ResponseEntity<List<RobotLabelsDTO>> getAllRobotLabels() {
        List<RobotLabelsDTO> list = service.getAllRobotLabels();
        return ResponseEntity.ok(list);
    }

    // DELETE /api/robot-labels/{userName}/{reportingDate}
    @DeleteMapping("/{userName}/{reportingDate}")
    public void deleteById(
            @PathVariable String userName,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime reportingDate) {
        service.deleteById(userName, reportingDate);
    }

    // GET /api/robot-labels/{userName}
    @GetMapping("/{userName}")
    public List<RobotLabelsDTO> getByUserName(@PathVariable String userName) {
        return service.findByUserName(userName);
    }

    // 🔸 POST /api/robot-labels - Create a new record
    @PostMapping("add")
    public void createRobotLabel(@RequestBody RobotLabelsDTO dto) {
        service.createRobotLabel(dto);
    }
}
