package admin.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import admin.model.Client;
import admin.model.ClientReportOption;
import admin.model.SysPrinsPrefix;
import admin.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClientDataGenerator {

    private final ClientRepository clientRepository;

    private final String[] usStates = {
            "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
            "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
            "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
            "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    };

    private final String[] sampleCities = {
            "New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia",
            "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville",
            "Fort Worth", "Columbus", "Charlotte", "San Francisco", "Indianapolis", "Seattle",
            "Denver", "Washington"
    };

    private final Random random = new Random();

    public ClientDataGenerator(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    public void generateClients() {
        List<Client> clients = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            String clientId = "CLIENT" + i;
            String city = sampleCities[random.nextInt(sampleCities.length)];
            String state = usStates[random.nextInt(usStates.length)];
            String zip = String.format("%05d", 10000 + random.nextInt(89999));
            String phone = "555-" + (1000000 + random.nextInt(8999999));
            String name = "Client Name " + i;

            // Generate 5 ClientReportOptions
            List<ClientReportOption> reportOptions = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                ClientReportOption option = new ClientReportOption();
                option.setReportId((long) j);
                option.setReceiveFlag(j % 2 == 0);
                option.setOutputTypeCd(1);
                option.setFileTypeCd(1);
                option.setEmailFlag(j % 2);
                option.setReportPasswordTx("pass" + j);
                reportOptions.add(option);
            }

            // Generate 10 SysPrinsPrefix
            List<SysPrinsPrefix> prefixes = new ArrayList<>();
            for (int k = 1; k <= 10; k++) {
                SysPrinsPrefix prefix = new SysPrinsPrefix();
                prefix.setPrefixId((long) (i * 10 + k));
                prefix.setPrefix("SP" + i + "_" + k);
                prefix.setDescription("Prefix Desc " + k);
                prefixes.add(prefix);
            }

            // Create Client and link the children
            Client client = new Client(
                    clientId,
                    name,
                    "123 " + city + " St.",
                    city,
                    state,
                    zip,
                    "Contact " + i,
                    phone,
                    i % 2 == 0,
                    reportOptions,
                    prefixes
            );

            // Assign back-reference from children to parent
            reportOptions.forEach(opt -> opt.setClient(client));
            prefixes.forEach(pre -> pre.setClient(client));

            clients.add(client);
        }

        clientRepository.saveAll(clients);
    }
}
