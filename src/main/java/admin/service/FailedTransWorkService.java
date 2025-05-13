package admin.service;

import admin.dto.FailedTransWorkDTO;
import admin.model.FailedTransWork;
import admin.model.FailedTransWorkId;
import admin.repository.FailedTransWorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FailedTransWorkService {

    private final FailedTransWorkRepository repository;

    public FailedTransWorkService(FailedTransWorkRepository repository) {
        this.repository = repository;
    }

    public FailedTransWork save(FailedTransWorkDTO dto) {
        FailedTransWork entity = new FailedTransWork();
        entity.setId(new FailedTransWorkId(dto.getCaseNumber(), dto.getPiId(), dto.getAccount()));
        entity.setDateTime(dto.getDateTime());
        entity.setNonMon(dto.getNonMon());
        entity.setRetryCount(dto.getRetryCount());
        entity.setMessage(dto.getMessage());
        return repository.save(entity);
    }

    public List<FailedTransWorkDTO> getAll() {
        return repository.findAll().stream().map(entity -> {
            FailedTransWorkDTO dto = new FailedTransWorkDTO();
            dto.setCaseNumber(entity.getId().getCaseNumber());
            dto.setPiId(entity.getId().getPiId());
            dto.setAccount(entity.getId().getAccount());
            dto.setDateTime(entity.getDateTime());
            dto.setNonMon(entity.getNonMon());
            dto.setRetryCount(entity.getRetryCount());
            dto.setMessage(entity.getMessage());
            return dto;
        }).collect(Collectors.toList());
    }
}
