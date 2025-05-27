package admin.service;

import admin.dto.DeletedTransactionDTO;
import admin.model.DeletedAccountTransaction;
import admin.model.DeletedTransaction;
import admin.repository.DeletedTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeletedTransactionService {

    private final DeletedTransactionRepository repository;

    public DeletedTransactionService(DeletedTransactionRepository repository) {
        this.repository = repository;
    }

    public List<DeletedTransactionDTO> getAllDeletedTransactions() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DeletedTransactionDTO convertToDTO(DeletedTransaction entity) {
        DeletedTransactionDTO dto = new DeletedTransactionDTO();
        dto.setCaseNumber(entity.getId().getCaseNumber());
        dto.setTransNo(entity.getId().getTransNo());
        dto.setDateTime(entity.getId().getDateTime());
        dto.setType(entity.getType());
        dto.setCommandLine(entity.getCommandLine());
        dto.setSystemType(entity.getSystemType());
        dto.setRetryCount(entity.getRetryCount());
        dto.setCycle(entity.getCycle());
        return dto;
    }
}
