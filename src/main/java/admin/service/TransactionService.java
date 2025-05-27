package admin.service;

import admin.dto.TransactionDTO;
import admin.model.Transaction;
import admin.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void deleteAllFailedTransactions() {
        repository.deleteAll();
    }

    public List<TransactionDTO> getTransactionsByCaseNumber(String caseNumber) {
        return repository.findByIdCaseNumber(caseNumber)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteTransactionsByCaseNumber(String caseNumber) {
        repository.deleteByIdCaseNumber(caseNumber);
    }

    public List<TransactionDTO> getAllTransactions() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertToDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setCaseNumber(transaction.getId().getCaseNumber());
        dto.setTransNo(transaction.getId().getTransNo());
        dto.setDateTime(transaction.getId().getDateTime());
        dto.setType(transaction.getType());
        dto.setCommandLine(transaction.getCommandLine());
        dto.setSystemType(transaction.getSystemType());
        dto.setRetryCount(transaction.getRetryCount());
        dto.setCycle(transaction.getCycle());
        return dto;
    }
}
