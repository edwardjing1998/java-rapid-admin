package admin.service;

import admin.dto.AccountTransactionDTO;
import admin.model.AccountTransaction;
import admin.repository.AccountTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import admin.dto.CaseDTO;
import admin.repository.CaseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CaseService {

    private static final Logger logger = LoggerFactory.getLogger(CaseService.class);

    private final CaseRepository caseRepository;
    private final AccountTransactionRepository transactionRepository;


    public CaseService(CaseRepository caseRepository, AccountTransactionRepository transactionRepository) {
        this.caseRepository = caseRepository;
        this.transactionRepository = transactionRepository;
    }

    public Map<String, List<CaseDTO>> getCasesByDisposition(List<String> dispositions) {
        List<Object[]> raw = caseRepository.fetchCasesByDisposition(dispositions);
        logger.info("Fetched {} case rows", raw.size());

        if (!raw.isEmpty()) {
            logger.info("Row[0] has {} columns", raw.get(0).length);  // log column count once
        }

        return raw.stream()
                .collect(Collectors.groupingBy(
                        row -> (String) row[0],
                        Collectors.mapping(this::mapToCaseDTO, Collectors.toList())
                ));
    }

    @Transactional
    public void deleteCasesByAccount(String account) {
        caseRepository.deleteByAccount(account);
    }

    private CaseDTO mapToCaseDTO(Object[] row) {
        return new CaseDTO.Builder()
                .client((String) row[0])
                .caseNumber((String) row[1])
                .account((String) row[2])
                .lastName((String) row[3])
                .firstName((String) row[4])
                .hmPhone((String) row[5])
                .wkPhone((String) row[6])
                .status((Character) row[7])
                .numCards(row[8] != null ? ((Number) row[8]).intValue() : null)
                .nextDate(row[9] != null ? ((Timestamp) row[9]).toLocalDateTime() : null)
                .reason((Character) row[10])
                .disposition((Character) row[11])
                .inDate(row[12] != null ? ((Timestamp) row[12]).toLocalDateTime() : null)
                .deliveryId(row[13] != null ? ((Number) row[13]).intValue() : null)
                .sysPrin((String) row[14])
                .outDate(row[15] != null ? ((Timestamp) row[15]).toLocalDateTime() : null)
                .cycle((Character) row[16])
                .active(row[17] != null ? (Boolean) row[17] : false)
                .inHour(row[18] != null ? ((Number) row[18]).intValue() : null)
                .autoDate(row[19] != null ? ((Timestamp) row[19]).toLocalDateTime() : null)
                .subreason(row[20] != null ? ((Number) row[20]).intValue() : null)
                .piId((String) row[21])
                .account((String) row[22])
                .build();
    }

    public CaseDTO getCaseWithTransactions(String caseNumber) {
        Optional<admin.model.Case> optionalCase = caseRepository.findById(caseNumber);
        if (optionalCase.isEmpty()) {
            throw new RuntimeException("Case not found: " + caseNumber);
        }

        admin.model.Case caseEntity = optionalCase.get();

        List<AccountTransaction> transactions = transactionRepository.findByCaseEntity_CaseNumber(caseNumber);

        List<AccountTransactionDTO> transactionDTOs = transactions.stream()
                .map(this::mapToTransactionDTO)
                .collect(Collectors.toList());

        return new CaseDTO.Builder()
                .caseNumber(caseEntity.getCaseNumber())
                .account(caseEntity.getAccount())
                .firstName(caseEntity.getFirstName())
                .lastName(caseEntity.getLastName())
                .hmPhone(caseEntity.getHmPhone())
                .wkPhone(caseEntity.getWkPhone())
                .status(caseEntity.getStatus())
                .active(caseEntity.getActive())
                .disposition(caseEntity.getDisposition())
                .inDate(caseEntity.getInDate())
                .outDate(caseEntity.getOutDate())
                .nextDate(caseEntity.getNextDate())
                .autoDate(caseEntity.getAutoDate())
                .numCards(caseEntity.getNumCards())
                .subreason(caseEntity.getSubreason())
                .sysPrin(caseEntity.getSysPrin())
                .deliveryId(caseEntity.getDeliveryId())
                .piId(caseEntity.getPiId())
                .accountTokenid(caseEntity.getAccountTokenid())
                .accountTransactions(transactionDTOs)
                .build();
    }

    private AccountTransactionDTO mapToTransactionDTO(AccountTransaction txn) {
        AccountTransactionDTO dto = new AccountTransactionDTO();
        dto.setCaseNumber(txn.getCaseEntity().getCaseNumber());
        dto.setTransNo(txn.getId().getTransNo());
        dto.setDateTime(txn.getId().getDateTime());
        dto.setPiId(txn.getPiId());
        dto.setAccount(txn.getAccount());
        dto.setActionId(txn.getActionId());
        dto.setUid(txn.getUid());
        dto.setDocumentNo(txn.getDocumentNo());
        dto.setSysPrin(txn.getSysPrin());
        dto.setNoCards(txn.getNoCards());
        dto.setActionReason(txn.getActionReason());
        dto.setOperatorTime(txn.getOperatorTime());
        dto.setWorkstationName(txn.getWorkstationName());
        dto.setPostageCategoryCd(txn.getPostageCategoryCd());
        dto.setAltAcctId(txn.getAltAcctId());
        dto.setMemberSeqId(txn.getMemberSeqId());
        return dto;
    }
}
