package admin.config.data;

import admin.model.*;
import admin.repository.AccountTransactionRepository;
import admin.repository.AddressRepository;
import admin.repository.CaseRepository;
import admin.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Profile("local")
public class CaseDataGenerator {

    private final CaseRepository caseRepository;
    private final ClientRepository clientRepository;

    private final AddressRepository addressRepository;

    private final AccountTransactionRepository accountTransactionRepository;
    private final Random random = new Random();

    private final Character[] dispositions = {'R', 'H', 'D', 'B', 'S'};

    public CaseDataGenerator(CaseRepository caseRepository, ClientRepository clientRepository, AddressRepository addressRepository, AccountTransactionRepository accountTransactionRepository) {
        this.caseRepository = caseRepository;
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.accountTransactionRepository = accountTransactionRepository;
    }

    private final String[][] sampleAddresses = {
            {"123 Elm St", "New York", "NY"},
            {"456 Oak Ave", "Los Angeles", "CA"},
            {"789 Maple Dr", "Chicago", "IL"},
            {"321 Pine Rd", "Houston", "TX"},
            {"654 Cedar Blvd", "Phoenix", "AZ"},
            {"987 Birch Ln", "Philadelphia", "PA"},
            {"159 Spruce Ct", "San Antonio", "TX"},
            {"753 Walnut Way", "San Diego", "CA"},
            {"852 Chestnut Pl", "Dallas", "TX"},
            {"963 Poplar Cir", "San Jose", "CA"}
    };

    public void generateCases() {
        List<Client> clients = clientRepository.findAllWithSysPrins();  // <- Use custom query here
        List<Case> allCases = new ArrayList<>();
        List<Address> allAddresses = new ArrayList<>();
        List<AccountTransaction> allTransactions = new ArrayList<>();

        for (Client client : clients) {
            List<SysPrin> sysPrins = client.getSysPrins();
            if (sysPrins == null || sysPrins.isEmpty()) continue;

            for (int i = 1; i <= 10; i++) {
                int dispositionIndex = i % dispositions.length;
                Character disposition = dispositions[dispositionIndex];

                SysPrin sysPrin = sysPrins.get(dispositionIndex % sysPrins.size());
                String sysPrinCode = sysPrin.getId().getSysPrin();

                Case c = new Case();
                c.setCaseNumber(client.getClient() + disposition + "C" + i);
                c.setPiId("PI" + i);
                c.setAccount("ACC" + random.nextInt(10000));
                c.setLastName("Doe" + i);
                c.setFirstName("John" + i);

                char[] statuses = {'A', 'X', 'D', 'Z'};
                c.setStatus(statuses[random.nextInt(statuses.length)]);
                c.setNumCards(random.nextInt(5) + 1);
                c.setNextDate(LocalDateTime.now().plusDays(i));
                char[] reasons = {'0', '1', '2', '3', '4', '5'};
                c.setReason(reasons[random.nextInt(reasons.length)]);
                c.setDisposition(disposition);
                c.setInDate(LocalDateTime.now());
                c.setDeliveryId(i);
                c.setSysPrin(sysPrinCode);
                c.setOutDate(LocalDateTime.now().plusDays(5));
                char[] cycles = {'C', '0'};
                c.setCycle(cycles[random.nextInt(cycles.length)]);
                c.setActive(random.nextBoolean());
                c.setInHour(1);
                c.setAutoDate(LocalDateTime.now().plusDays(2));
                c.setSubreason(i);
                c.setHmPhone("416-hm-" + i);
                c.setWkPhone("416-wk-" + i);
                allCases.add(c);

                String[] sampleAddress = sampleAddresses[random.nextInt(sampleAddresses.length)];
                Address address = new Address();
                address.setCaseNumberId(client.getClient() + disposition + "C" + i);
                address.setAddressEntityCd("1");
                address.setAddr1(sampleAddress[0]);
                address.setCity(sampleAddress[1]);
                address.setState(sampleAddress[2]);
                address.setZip("1000" + i);
                address.setAddr2("Suite " + i);
                address.setAddr3("Building " + i);
                address.setAddr4("Floor " + i);
                address.setAlternateName("AltName" + i);
                address.setDeliveryPointCd(String.valueOf(i));

                allAddresses.add(address);

                AccountTransactionId txId = new AccountTransactionId(
                        client.getClient() + disposition + "C" + i,
                        new BigDecimal(i),
                        LocalDateTime.now().minusDays(i)
                );

                AccountTransaction tx = new AccountTransaction();
                tx.setCaseEntity(c);
                tx.setId(txId);
                tx.setPiId(c.getPiId());
                tx.setAccount(c.getAccount());
                tx.setActionId("ROA");
                tx.setUid("UID" + i);
                tx.setDocumentNo("DOC" + i);
                tx.setSysPrin(sysPrinCode);
                tx.setNoCards(random.nextInt(5) + 1);
                tx.setActionReason("Test reason " + i);
                tx.setOperatorTime(random.nextInt(500));
                tx.setWorkstationName("WS" + i);
                tx.setPostageCategoryCd((short) (i % 4));
                tx.setAltAcctId("ALT" + i);
                tx.setMemberSeqId("SEQ" + i);

                allTransactions.add(tx);
            }
        }

        addressRepository.saveAll(allAddresses);
        caseRepository.saveAll(allCases);
        accountTransactionRepository.saveAll(allTransactions);

    }
}
