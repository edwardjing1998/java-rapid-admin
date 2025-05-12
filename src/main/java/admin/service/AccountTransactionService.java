package admin.service;

import admin.dto.AccountTransactionDTO;
import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import admin.repository.AccountTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
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

        return accountTransactionRepository.save(entity);
    }
}
