package admin.service;

import admin.dto.AccountTransactionDTO;
import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import admin.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository repository;

    public AccountTransactionService(AccountTransactionRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AccountTransaction save(AccountTransactionDTO dto) {
        AccountTransaction entity = new AccountTransaction();

        // Set composite key
        AccountTransactionId id = new AccountTransactionId();
        id.setCaseNumber(dto.getCaseNumber());
        id.setTransNo(dto.getTransNo());
        id.setDateTime(dto.getDateTime());
        entity.setId(id);

        // Set remaining fields
        entity.setPiId(dto.getPiId());
        entity.setAccount(dto.getAccount());
        entity.setActionId(dto.getActionId());
        entity.setUid(dto.getUid());
        entity.setDocumentNo(dto.getDocumentNo());
        entity.setSysPrin(dto.getSysPrin());
        entity.setNoCards(dto.getNoCards());
        entity.setActionReason(dto.getActionReason());
        entity.setOperatorTime(dto.getOperatorTime());
        entity.setWorkstationName(dto.getWorkstationName());
        entity.setPostageCategoryCd(dto.getPostageCategoryCd());
        entity.setAltAcctId(dto.getAltAcctId());
        entity.setMemberSeqId(dto.getMemberSeqId());

        return repository.save(entity);
    }

    @Transactional
    public void deleteByAccount(String account) {
        repository.deleteByAccount(account);
    }


    public List<AccountTransactionDTO> getAllAccountTransactions() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AccountTransactionDTO mapToDTO(AccountTransaction entity) {
        AccountTransactionDTO dto = new AccountTransactionDTO();
        dto.setCaseNumber(entity.getId().getCaseNumber());
        dto.setTransNo(entity.getId().getTransNo());
        dto.setDateTime(entity.getId().getDateTime());
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
        return dto;
    }

}
