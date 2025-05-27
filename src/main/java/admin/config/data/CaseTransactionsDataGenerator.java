package admin.config.data;

import admin.model.AccountTransaction;
import admin.model.AccountTransactionId;
import admin.model.Case;
import admin.model.Transaction;
import admin.model.TransactionId;
import admin.repository.AccountTransactionRepository;
import admin.repository.CaseRepository;
import admin.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CaseTransactionsDataGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CaseTransactionsDataGenerator.class);
    private final TransactionRepository failedTransRepository;
    private final AccountTransactionRepository accountTransactionRepository;
    private final CaseRepository caseRepository;

    public CaseTransactionsDataGenerator(TransactionRepository failedTransRepository,
                                         AccountTransactionRepository accountTransactionRepository,
                                         CaseRepository caseRepository) {
        this.failedTransRepository = failedTransRepository;
        this.accountTransactionRepository = accountTransactionRepository;
        this.caseRepository = caseRepository;
    }

    @PostConstruct
    public void generateData() {
        List<String> commandLines = List.of(
                "EXECUTE FRPC 'CUSTOMER_UPDATE', '', @ADDR_CNTN_LINE_ONE_TX='6855 PACIFIC STREET', @ADDR_CNTN_LINE_TWO_TX='', @CITY_NM='OMAHA', @ADDR_SBDV_ONE_TX='NE', @PSTL_CD='68106'",
                "EXECUTE FRPC 'CONTACT_HISTORY_ADD', '5480302000296846', 'RAPID', '', '', 'RRD PI:5480303000546412 1 card(s) placed in research.  '",
                "EXECUTE FRPC 'CUSTOMER_UPDATE', 'C12360110239771782028053', @ADDR_CNTN_LINE_ONE_TX='2000 N LAUDERDALE AVE APT 106', @ADDR_CNTN_LINE_TWO_TX='', @CITY_NM='TAMPA', @ADDR_SBDV_ONE_TX='FL', @PSTL_CD='33608-4771'",
                "EXEC FRPC 'CNONMON','4470431112096227','698','00',,'BLL1','F',,,,,,,'4543 KNOLLCROFT ROAD',' ',,,'TROTWOOD','OH','USA','45426-1936',,,,,'P',,,,,'U'"
        );

        List<Transaction> sampleData = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            String caseNum = String.format("CASE%03d", i);
            String cycle = String.valueOf((char) ('A' + (i % 26)));

            String randomCommand = commandLines.get(new java.util.Random().nextInt(commandLines.size()));

            sampleData.add(createEntry(caseNum, new BigDecimal(1000 + i), LocalDateTime.now().minusHours(i),
                    (short) (i % 5 + 1), randomCommand, "OS" + i, (i % 3), cycle));
        }

        failedTransRepository.saveAll(sampleData);
        logger.info("✅ Inserted sample FAILED_TRANS records.");

        // (Leave your existing AccountTransaction/Case setup below unchanged)
        for (Transaction ft : sampleData) {
            Case caseEntity = caseRepository.findById(ft.getId().getCaseNumber()).orElse(null);
            if (caseEntity == null) {
                caseEntity = new Case();
                caseEntity.setCaseNumber(ft.getId().getCaseNumber());
                caseEntity.setActive(true);
                caseEntity.setFirstName("John");
                caseEntity.setLastName("Doe");
                caseEntity.setAccount("ACC" + ft.getCycle());
                caseEntity.setPiId("PI" + ft.getCycle());
                caseEntity.setPrimaryPiId("PPI" + ft.getCycle());
                caseEntity.setHmPhone("5551234567");
                caseEntity.setWkPhone("5559876543");
                caseEntity.setSysPrin("SP001");
                caseEntity.setCycle(ft.getCycle().charAt(0));
                caseEntity.setStatus('A');
                caseEntity.setInDate(LocalDateTime.now().minusDays(1));
                caseEntity.setNextDate(LocalDateTime.now().plusDays(1));
                caseEntity.setOutDate(LocalDateTime.now());

                caseRepository.save(caseEntity);
            }

            AccountTransaction tx = new AccountTransaction();
            AccountTransactionId txId = new AccountTransactionId(ft.getId().getCaseNumber(), ft.getId().getTransNo(), ft.getId().getDateTime());
            tx.setId(txId);
            tx.setCaseEntity(caseEntity);
            tx.setPiId("PI" + ft.getCycle());
            tx.setAccount("ACC" + ft.getCycle());
            tx.setActionId("ACT");
            tx.setUid("user123");
            tx.setDocumentNo("DOC" + ft.getCycle());
            tx.setSysPrin("SP001");
            tx.setNoCards(1);
            tx.setActionReason("Reason for " + ft.getCycle());
            tx.setOperatorTime(120);
            tx.setWorkstationName("WS-1");
            tx.setPostageCategoryCd((short) 1);
            tx.setAltAcctId("ALT123");
            tx.setMemberSeqId("SEQ1");

            accountTransactionRepository.save(tx);
        }

        logger.info("✅ Inserted sample ACCOUNT_TRANS records.");
    }


    private Transaction createEntry(String caseNumber,
                                    BigDecimal transNo,
                                    LocalDateTime dateTime,
                                    Short type,
                                    String commandLine,
                                    String systemType,
                                    Integer retryCount,
                                    String cycle) {
        TransactionId id = new TransactionId(caseNumber, transNo, dateTime);
        Transaction ft = new Transaction();
        ft.setId(id);
        ft.setType(type);
        ft.setCommandLine(commandLine);
        ft.setSystemType(systemType);
        ft.setRetryCount(retryCount);
        ft.setCycle(cycle);
        return ft;
    }
}
