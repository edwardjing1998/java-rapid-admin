package admin.config.data;

import admin.model.*;
import admin.repository.AdminQueryListRepository;
import admin.repository.ClientRepository;
import admin.repository.InvalidDelivAreaRepository;
import admin.repository.SysPrinsPrefixRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClientDataGenerator {

    private final ClientRepository clientRepository;
    private final AdminQueryListRepository adminQueryListRepository;
    private final InvalidDelivAreaRepository invalidDelivAreaRepository;
    private final SysPrinsPrefixRepository sysPrinsPrefixRepository;

    private final String[] usStates = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

    private final String[] sampleCities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "Charlotte", "San Francisco", "Indianapolis", "Seattle", "Denver", "Washington"};

    private final String[] usBanks = {"JPMorgan Chase", "Bank of America", "Wells Fargo", "Citigroup", "Goldman Sachs", "Morgan Stanley", "U.S. Bancorp", "PNC Financial Services", "Truist Financial", "Capital One Financial", "Charles Schwab", "Fifth Third Bancorp", "Ally Financial", "KeyCorp", "Regions Financial", "Huntington Bancshares", "First Republic Bank", "M&T Bank Corporation", "Citizens Financial", "Comerica", "Zions Bancorporation", "BOK Financial", "Synovus Financial", "Raymond James Financial", "SVB Financial", "First Horizon", "East West Bancorp", "New York Community Bancorp", "Wintrust Financial", "Western Alliance"};

    private final Random random = new Random();

    public ClientDataGenerator(ClientRepository clientRepository, AdminQueryListRepository adminQueryListRepository, InvalidDelivAreaRepository invalidDelivAreaRepository, SysPrinsPrefixRepository sysPrinsPrefixRepository) {
        this.clientRepository = clientRepository;
        this.adminQueryListRepository = adminQueryListRepository;
        this.invalidDelivAreaRepository = invalidDelivAreaRepository;
        this.sysPrinsPrefixRepository = sysPrinsPrefixRepository;
    }

    public void generateClients() {
        List<AdminQueryList> reports = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            AdminQueryList report = new AdminQueryList();
            report.setDefaultFileNm("Report " + j);
            report.setReportByClientFlag(random.nextBoolean());
            report.setDbDriverType("SQL Server");
            report.setQueryName("Query" + j);
            report.setInputDataFields("Field1, Field2");
            report.setFileExt(random.nextBoolean() ? "TXT" : "XLT");
            report.setFileHeaderInd(1);
            report.setReportDbServer("localhost");
            report.setReportDb("demoDb");
            report.setReportDbUserid("admin");
            report.setReportDbPasswrd("adminpass");
            report.setReportDbIpAndPort("127.0.0.1:1433");
            reports.add(report);
        }
        adminQueryListRepository.saveAll(reports);

        List<Client> clients = new ArrayList<>();
        List<SysPrinsPrefix> allPrefixes = new ArrayList<>();

        for (int i = 0; i < usBanks.length; i++) {
            String clientId = String.valueOf(i + 1);
            String city = sampleCities[random.nextInt(sampleCities.length)];
            String state = usStates[random.nextInt(usStates.length)];
            String zip = String.format("%05d", 10000 + random.nextInt(89999));
            String phone = "555-" + (1000000 + random.nextInt(8999999));
            String name = usBanks[i];
            String billingSp = "BILL" + (i + 1);

            List<ClientReportOption> reportOptions = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                ClientReportOption option = new ClientReportOption();
                option.setId(new ClientReportOptionId(clientId, j));
                option.setReceiveFlag(j % 2 == 0);
                option.setOutputTypeCd(random.nextInt(3));
                option.setFileTypeCd(random.nextInt(3));
                option.setEmailFlag(random.nextInt(3));
                option.setReportPasswordTx("pass" + j);
                option.setReport(reports.get((j - 1) % reports.size()));
                option.setEmailBodyTx("Email body for " + clientId + " item " + j);
                reportOptions.add(option);
            }

            Map<String, SysPrinsPrefix> prefixCache = new HashMap<>();
            List<SysPrinsPrefix> prefixes = new ArrayList<>();
            for (int k = 1; k <= 5 + random.nextInt(5); k++) {
                String atmCashRule = random.nextBoolean() ? "0" : "1";
                String prefixStr = "PREFIX" + k;
                String cacheKey = billingSp + "-" + atmCashRule + "-" + prefixStr;
                if (!prefixCache.containsKey(cacheKey)) {
                    SysPrinsPrefixId prefixId = new SysPrinsPrefixId(billingSp, prefixStr, atmCashRule);
                    SysPrinsPrefix newPrefix = new SysPrinsPrefix(prefixId);
                    prefixCache.put(cacheKey, newPrefix);
                    prefixes.add(newPrefix);
                    allPrefixes.add(newPrefix);
                }
            }

            Client client = new Client(
                    clientId,
                    name,
                    "123 " + city + " St.",
                    city,
                    state,
                    zip,
                    "Contact " + (i + 1),
                    phone,
                    (i + 1) % 2 == 0,
                    "Fax-" + (i + 1),
                    billingSp,
                    (i + 1) % 2,
                    (i + 1) % 3,
                    (i + 1) % 2 == 0,
                    (i + 1) % 2 == 1,
                    (i + 1) % 2,
                    String.valueOf(i + 1),
                    (i + 1) % 2 == 0,
                    reportOptions,
                    prefixes,
                    new ArrayList<>(),
                    new ArrayList<>()
            );
            clients.add(client);
        }

        clientRepository.saveAll(clients);
        sysPrinsPrefixRepository.saveAll(allPrefixes);
    }
}
