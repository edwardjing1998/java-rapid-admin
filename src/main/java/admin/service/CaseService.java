package admin.service;

import admin.dto.AccountTransactionDTO;
import admin.dto.BulkCardDTO;
import admin.dto.FailedTransactionDTO;
import admin.dto.LabelsDTO;
import admin.model.*;
import admin.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import admin.dto.CaseDTO;

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
    private final BulkCardRepository bulkCardRepository;

    private final FailedTransactionRepository failedTransactionRepository;

    private final LabelsRepository labelsRepository;


    public CaseService(CaseRepository caseRepository, AccountTransactionRepository transactionRepository, BulkCardRepository bulkCardRepository, FailedTransactionRepository failedTransactionRepository, LabelsRepository labelsRepository) {
        this.caseRepository = caseRepository;
        this.transactionRepository = transactionRepository;
        this.bulkCardRepository = bulkCardRepository;
        this.failedTransactionRepository = failedTransactionRepository;
        this.labelsRepository = labelsRepository;
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
        List<Case> cases = caseRepository.findCaseByAccount(account);

        if (cases == null || cases.isEmpty()) {
            logger.warn("No cases found for account: {}", account);
            return;
        }

        String caseNumber = cases.get(0).getCaseNumber();

        labelsRepository.deleteAllByIdCaseNumber(caseNumber);
        transactionRepository.deleteByIdCaseNumber(caseNumber);
        bulkCardRepository.deleteByIdCaseNumber(caseNumber);
        failedTransactionRepository.deleteByIdCaseNumber(caseNumber);
        caseRepository.deleteByAccount(account);

        logger.info("Deleted case and associated data for account: {}", account);
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
        List<BulkCard> bulkCards = bulkCardRepository.findByIdCaseNumber(caseNumber);

        List<FailedTransaction> failedTransactions = failedTransactionRepository.findByIdCaseNumber(caseNumber);
        logger.info("failedTransactions size is {}", failedTransactions.size());

        List<Labels> labels = labelsRepository.findByIdCaseNumber(caseNumber);

        List<AccountTransactionDTO> transactionDTOs = transactions.stream()
                .map(this::mapToTransactionDTO)
                .collect(Collectors.toList());

        List<BulkCardDTO> bulkCardDTOS = bulkCards.stream()
                .map(this::mapToBulkDTO)
                .collect(Collectors.toList());

        List<FailedTransactionDTO> failedTransactionDTOS = failedTransactions.stream()
                .map(this::mapToFailedTransactionDTO)
                .collect(Collectors.toList());

        List<LabelsDTO> labelsDTOS = labels.stream()
                .map(this::mapToLabelDTO)
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
                .bulkCards(bulkCardDTOS)
                .failedTransactions(failedTransactionDTOS)
                .labels(labelsDTOS)
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

    private BulkCardDTO mapToBulkDTO(BulkCard bulkCard) {
        BulkCardDTO dto = new BulkCardDTO();
        dto.setCaseNumber(bulkCard.getId().getCaseNumber());
        dto.setBulkPiId(bulkCard.getId().getBulkPiId());
        dto.setInDate(bulkCard.getId().getInDate());
        dto.setPiId(bulkCard.getId().getPiId());
        return dto;
    }

    private FailedTransactionDTO mapToFailedTransactionDTO(FailedTransaction failedTransaction) {
        FailedTransactionDTO dto = new FailedTransactionDTO();
        dto.setCaseNumber(failedTransaction.getId().getCaseNumber());
        dto.setTransNo(failedTransaction.getId().getTransNo());
        dto.setCommandLine(failedTransaction.getCommandLine());
        dto.setCycle(failedTransaction.getCycle());
        dto.setType(failedTransaction.getType());
        dto.setDateTime(failedTransaction.getDateTime());
        dto.setRetryCount(failedTransaction.getRetryCount());
        dto.setSystemType(failedTransaction.getSystemType());

        return dto;
    }

    private LabelsDTO mapToLabelDTO(Labels labels) {
        LabelsDTO dto = new LabelsDTO();
        dto.setCaseNumber(labels.getId().getCaseNumber());
        dto.setBarCodeTx(labels.getId().getBarCodeTx());
        dto.setStatus(labels.getId().getStatus());
        dto.setCardTypeTx(labels.getId().getCardTypeTx());
        dto.setType(labels.getId().getText1());
        dto.setText1(labels.getId().getText1());
        dto.setText2(labels.getId().getText2());
        dto.setText3(labels.getId().getText3());
        dto.setText4(labels.getId().getText4());
        dto.setText5(labels.getId().getText5());
        dto.setText3Addr4(labels.getId().getText3Addr4());
        dto.setType(labels.getId().getType());
        return dto;
    }
}
