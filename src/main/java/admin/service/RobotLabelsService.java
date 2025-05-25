package admin.service;

import admin.dto.RobotLabelsDTO;
import admin.model.RobotLabels;
import admin.model.RobotLabelsId;
import admin.repository.RobotLabelsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotLabelsService {

    private final RobotLabelsRepository repository;

    public RobotLabelsService(RobotLabelsRepository repository) {
        this.repository = repository;
    }

    public List<RobotLabelsDTO> getAllRobotLabels() {
        List<RobotLabels> entities = repository.findAll();
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private RobotLabelsDTO mapToDTO(RobotLabels entity) {
        RobotLabelsDTO dto = new RobotLabelsDTO();
        dto.setUserName(entity.getId().getUserName());
        dto.setReportingDate(entity.getId().getReportingDate());
        dto.setBundles(entity.getBundles());
        dto.setIndividualLabels(entity.getIndividualLabels());
        dto.setRobotLabelTotal(entity.getRobotLabelTotal());
        return dto;
    }

    // Delete by RobotLabelsId
    public void deleteById(String userName, LocalDateTime reportingDate) {
        RobotLabelsId id = new RobotLabelsId(userName, reportingDate);
        repository.deleteById(id);
    }

    // Find by userName
    public List<RobotLabelsDTO> findByUserName(String userName) {
        List<RobotLabels> labels = repository.findByIdUserName(userName);
        return labels.stream()
                .map(label -> new RobotLabelsDTO(
                        label.getId().getUserName(),
                        label.getId().getReportingDate(),
                        label.getBundles(),
                        label.getIndividualLabels(),
                        label.getRobotLabelTotal()
                ))
                .collect(Collectors.toList());
    }

    // 🔸 Create a new RobotLabels record
    public void createRobotLabel(RobotLabelsDTO dto) {
        RobotLabels entity = new RobotLabels();
        entity.setId(new RobotLabelsId(dto.getUserName(), dto.getReportingDate()));
        entity.setBundles(dto.getBundles());
        entity.setIndividualLabels(dto.getIndividualLabels());
        entity.setRobotLabelTotal(dto.getRobotLabelTotal());

        repository.save(entity);
    }
}
