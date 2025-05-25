package admin.service;

import admin.dto.LabelsDTO;
import admin.model.Labels;
import admin.repository.LabelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelsService {

    private final LabelsRepository repository;

    public LabelsService(LabelsRepository repository) {
        this.repository = repository;
    }

    public List<LabelsDTO> getAllLabels() {
        List<Labels> entities = repository.findAll();
        return entities.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<LabelsDTO> findByType(String type) {
        return repository.findByIdType(type).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LabelsDTO mapToDTO(Labels entity) {
        LabelsDTO dto = new LabelsDTO();
        dto.setText1(entity.getId().getText1());
        dto.setText2(entity.getId().getText2());
        dto.setText3(entity.getId().getText3());
        dto.setText4(entity.getId().getText4());
        dto.setText5(entity.getId().getText5());
        dto.setStatus(entity.getId().getStatus() != null && entity.getId().getStatus());
        dto.setType(entity.getId().getType());
        dto.setCaseNumber(entity.getId().getCaseNumber());
        dto.setCardTypeTx(entity.getId().getCardTypeTx());
        dto.setBarCodeTx(entity.getId().getBarCodeTx());
        dto.setText3Addr3(entity.getId().getText3Addr3());
        dto.setText3Addr4(entity.getId().getText3Addr4());
        return dto;
    }
}
