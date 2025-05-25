package admin.config.data;

import admin.model.DeletedCase;
import admin.repository.DeletedCaseRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("local")
public class DeletedCaseDataGenerator {

    private final DeletedCaseRepository deletedCaseRepository;
    private final Random random = new Random();

    private final Character[] dispositions = {'R', 'H', 'D', 'B', 'S', 'M', 'C', 'X', 'Z'};
    private final Character[] issuanceCodes = {'N', 'P', 'R', 'U'};

    private final String[] firstNames = {
            "Alice", "Bob", "Charlie", "David", "Eve",
            "Frank", "Grace", "Henry", "Irene", "Jack"
    };

    private final String[] lastNames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"
    };

    public DeletedCaseDataGenerator(DeletedCaseRepository deletedCaseRepository) {
        this.deletedCaseRepository = deletedCaseRepository;
    }

    @PostConstruct
    public void generateDeletedCases() {
        List<DeletedCase> cases = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {

            int dispositionIndex = i % dispositions.length;
            Character disposition = dispositions[dispositionIndex];

            int issuanceCodesIndex = i % issuanceCodes.length;
            Character issuanceCode = issuanceCodes[issuanceCodesIndex];



            DeletedCase deletedCase = new DeletedCase();
            String caseNumber = String.format("CASE%04d", i);
            String piId = "PI" + String.format("%05d", i);
            String primaryPiId = "PPI" + String.format("%05d", i);
            String customerId = "CUST" + String.format("%05d", i);
            String sysPrin = "SP" + String.format("%03d", i % 10);

            deletedCase.setCaseNumber(caseNumber);
            deletedCase.setPiId(piId);
            deletedCase.setPrimaryPiId(primaryPiId);
            deletedCase.setCustomerId(customerId);
            deletedCase.setAccount("ACC" + i);
            deletedCase.setFirstName(firstNames[i % firstNames.length]);
            deletedCase.setLastName(lastNames[i % lastNames.length]);
            deletedCase.setHomePhone("555-010" + String.format("%02d", i));
            deletedCase.setWorkPhone("555-020" + String.format("%02d", i));
            deletedCase.setEntityCode(String.valueOf(random.nextInt(2)));
            deletedCase.setRoleCode("R" + (i % 3));
            deletedCase.setPiStatus(String.valueOf(random.nextInt(2)));
            deletedCase.setStatus(String.valueOf(random.nextInt(2)));
            deletedCase.setActive(i % 2 == 0);
            deletedCase.setReason(String.valueOf(random.nextInt(6)));
            deletedCase.setSubreason(Integer.valueOf(i % 3));
            deletedCase.setDisposition(Character.toString(disposition));
            deletedCase.setInHour(i % 24);
            deletedCase.setInDate(LocalDateTime.now().minusDays(i));
            deletedCase.setNextDate(LocalDateTime.now().plusDays(i));
            deletedCase.setOutDate(LocalDateTime.now().plusDays(i + 1));
            deletedCase.setAutoDate(LocalDateTime.now().minusDays(i * 2));
            deletedCase.setNumCards(i % 10);
            deletedCase.setFinalActionCardsNumber(i % 5);
            deletedCase.setDeliveryId(400 + i);
            deletedCase.setSysPrin(sysPrin);
            deletedCase.setCycle(String.valueOf(random.nextInt(2)));
            deletedCase.setFirstUpdateVendorId("V"+ String.valueOf(random.nextInt(100)));
            deletedCase.setContactCode(String.valueOf(random.nextInt(9)));
            deletedCase.setContactPhoneNumber("555-030" + String.format("%02d", i));
            deletedCase.setReturnReasonCode(String.valueOf(random.nextInt(9)));
            deletedCase.setIssuanceCode(Character.toString(issuanceCode));
            deletedCase.setIssuanceDate(LocalDateTime.now().minusMonths(i % 6));
            deletedCase.setWorkstationName("WS" + i);
            deletedCase.setOperatorCode(String.valueOf(random.nextInt(99)));
            deletedCase.setBarcodeTypeCode(String.valueOf(random.nextInt(9)));
            deletedCase.setRecordTypeText(String.valueOf(random.nextInt(99)));
            deletedCase.setServiceTypeText(String.valueOf(random.nextInt(999)));
            deletedCase.setMailerId(generateMailerId(i));
            deletedCase.setAs400ClientId(generateAs400ClientId(i));
            deletedCase.setAs400SystemId(generateAs400SystemId(i));
            deletedCase.setBasicSupplementalId(String.valueOf(random.nextInt(9)));
            deletedCase.setOriginalMailDate(LocalDateTime.now().minusDays(i * 3));
            deletedCase.setMessageId("MSG" + i);
            deletedCase.setMailMethod("Method" + (i % 2));
            deletedCase.setSourceFile("SourceFile" + i);
            deletedCase.setCustomerId2("CUST2-" + i);
            deletedCase.setMarketCode("M" + String.valueOf(random.nextInt(9)));
            deletedCase.setAccountTokenId(generatePIAccountTokenId(i));
            deletedCase.setPiIdTokenId(generatePIAccountTokenId(i));
            deletedCase.setPrimaryPiIdTokenId(generatePIAccountTokenId(i));
            deletedCase.setMsIssueDate(String.valueOf(random.nextInt(9999)));

            cases.add(deletedCase);
        }

        deletedCaseRepository.saveAll(cases);
    }

    private String generateAs400SystemId(int index) {
        char[] base35Chars = "1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        int value = index;
        do {
            sb.insert(0, base35Chars[value % base35Chars.length]);
            value /= base35Chars.length;
        } while (value > 0);
        while (sb.length() < 8) sb.insert(0, '1'); // pad to 4 characters
        return sb.toString();
    }
    private String generateAs400ClientId(int index) {
        char[] base35Chars = "1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        int value = index;
        do {
            sb.insert(0, base35Chars[value % base35Chars.length]);
            value /= base35Chars.length;
        } while (value > 0);
        while (sb.length() < 4) sb.insert(0, '1'); // pad to 4 characters
        return sb.toString();
    }

    private String generateMailerId(int index) {
        char[] base35Chars = "123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        int value = index;
        do {
            sb.insert(0, base35Chars[value % base35Chars.length]);
            value /= base35Chars.length;
        } while (value > 0);
        while (sb.length() < 9) sb.insert(0, '1'); // pad to 8 characters
        return sb.toString();
    }

    private String generatePIAccountTokenId(int index) {
        char[] base35Chars = "123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        int value = index;
        do {
            sb.insert(0, base35Chars[value % base35Chars.length]);
            value /= base35Chars.length;
        } while (value > 0);
        while (sb.length() < 16) sb.insert(0, '1'); // pad to 8 characters
        return sb.toString();
    }
}
