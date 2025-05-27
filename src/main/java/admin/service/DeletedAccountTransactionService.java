package admin.service;

import admin.dto.DeletedAccountTransactionDTO;
import admin.dto.DeletedTransactionDTO;
import admin.model.DeletedAccountTransaction;
import admin.model.DeletedTransaction;
import admin.repository.DeletedAccountTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeletedAccountTransactionService {

    private final DeletedAccountTransactionRepository repository;

    public DeletedAccountTransactionService(DeletedAccountTransactionRepository repository) {
        this.repository = repository;
    }

    public List<DeletedAccountTransactionDTO> getAllDeletedAccountTransactions() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DeletedAccountTransactionDTO convertToDTO(DeletedAccountTransaction entity) {
        DeletedAccountTransactionDTO dto = new DeletedAccountTransactionDTO();

        // Map composite key fields
        dto.setCaseNumber(entity.getId().getCaseNumber());
        dto.setTransNo(entity.getId().getTransNo());
        dto.setDateTime(entity.getId().getDateTime());

        // Map other fields
        dto.setPiId(entity.getPiId());
        dto.setAccount(entity.getAccount());
        dto.setActionId(entity.getActionId());
        dto.setUid(entity.getUid());
        dto.setDocumentNo(entity.getDocumentNo());
        dto.setSysPrin(entity.getSysPrin());
        dto.setNoCards(entity.getNoCards());
        dto.setActionReason(entity.getActionReason());
        dto.setOperatorTime(entity.getOperatorTime());
        dto.setWorkstationName(entity.getWorkstationName());
        dto.setPostageCategoryCd(entity.getPostageCategoryCd());

        // Map associated DeletedTransaction entities to DTOs
        List<DeletedTransactionDTO> transactionDTOs = entity.getTransactions().stream()
                .map(this::convertTransactionToDTO)
                .collect(Collectors.toList());
        dto.setTransactions(transactionDTOs);

        return dto;
    }

    private DeletedTransactionDTO convertTransactionToDTO(DeletedTransaction tx) {
        DeletedTransactionDTO dto = new DeletedTransactionDTO();
        dto.setCaseNumber(tx.getId().getCaseNumber());
        dto.setTransNo(tx.getId().getTransNo());
        dto.setDateTime(tx.getId().getDateTime());
        dto.setType(tx.getType());
        dto.setCommandLine(tx.getCommandLine());
        dto.setSystemType(tx.getSystemType());
        dto.setRetryCount(tx.getRetryCount());
        dto.setCycle(tx.getCycle());
        // Optionally map its accountTransactions if you have a reverse relationship
        return dto;
    }
}
