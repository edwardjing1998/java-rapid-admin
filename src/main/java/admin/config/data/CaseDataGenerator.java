package admin.config.data;

import admin.model.Case;
import admin.model.Client;
import admin.model.SysPrin;
import admin.repository.CaseRepository;
import admin.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
    private final Random random = new Random();

    private final Character[] dispositions = {'R', 'H', 'D', 'B', 'S'};

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
                Character disposition = dispositions[dispositionIndex];

                SysPrin sysPrin = sysPrins.get(dispositionIndex % sysPrins.size());
                String sysPrinCode = sysPrin.getId().getSysPrin();

                Case c = new Case();
                c.setCaseNumber(client.getClient() + disposition + "C" + i);
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
                allCases.add(c);
            }
        }

        caseRepository.saveAll(allCases);
    }
}
