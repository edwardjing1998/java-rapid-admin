package admin.config.data;

import admin.model.Case;
import admin.model.Client;
import admin.model.SysPrin;
import admin.repository.CaseRepository;
import admin.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class CaseDataGenerator {

    private final CaseRepository caseRepository;
    private final ClientRepository clientRepository;
    private final Random random = new Random();

    private final String[] dispositions = {"R", "H", "D", "B", "S"};

    public CaseDataGenerator(CaseRepository caseRepository, ClientRepository clientRepository) {
        this.caseRepository = caseRepository;
        this.clientRepository = clientRepository;
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

        for (Client client : clients) {
            List<SysPrin> sysPrins = client.getSysPrins();
            if (sysPrins == null || sysPrins.isEmpty()) continue;

            for (int i = 1; i <= 10; i++) {
                int dispositionIndex = i % dispositions.length;
                String disposition = dispositions[dispositionIndex];

                SysPrin sysPrin = sysPrins.get(dispositionIndex % sysPrins.size());
                String sysPrinCode = sysPrin.getId().getSysPrin();

                Case c = new Case();
                c.setCaseNumber(client.getClient() + "-" + disposition + "-CASE-" + i);
                c.setAccount("ACC" + random.nextInt(10000));
                c.setLastName("Doe" + i);
                c.setFirstName("John" + i);

                c.setAddr2("Suite " + i);

                int addrIndex = (i + dispositionIndex) % sampleAddresses.length;
                String[] addrData = sampleAddresses[addrIndex];
                c.setAddr1(addrData[0]);
                c.setCity(addrData[1]);
                c.setState(addrData[2]);

                c.setZip(String.format("%05d", 10000 + random.nextInt(89999)));
                c.setHomePhone("555-100" + i);
                c.setWorkPhone("555-200" + i);
                c.setStatus("Active");
                c.setNumCards(random.nextInt(5) + 1);
                c.setNextDate(LocalDate.now().plusDays(i));
                c.setNoRenewal(i % 2 == 0);
                c.setReason("Reason" + i);
                c.setDisposition(disposition);
                c.setInDate(LocalDate.now());
                c.setDeliveryId("DLY" + i);
                c.setSysPrin(sysPrinCode);
                c.setOutDate(LocalDate.now().plusDays(5));
                c.setCycle("Cycle" + (i % 4));
                c.setActive(true);
                c.setInHour(LocalTime.now());
                c.setAutoDate(LocalDate.now().plusDays(2));
                c.setSubreason("Subreason" + i);
                c.setProdType("Type" + (i % 2));
                allCases.add(c);
            }
        }

        caseRepository.saveAll(allCases);
    }
}
