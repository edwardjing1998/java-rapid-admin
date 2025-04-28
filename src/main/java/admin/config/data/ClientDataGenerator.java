package admin.config.data;

import admin.model.*;
import admin.repository.AdminQueryListRepository;
import admin.repository.ClientRepository;
import admin.repository.InvalidDelivAreaRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClientDataGenerator {

    private final ClientRepository clientRepository;
    private final AdminQueryListRepository adminQueryListRepository;
    private final InvalidDelivAreaRepository invalidDelivAreaRepository;

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

    private final String[] usBanks = {
            "JPMorgan Chase", "Bank of America", "Wells Fargo", "Citigroup", "Goldman Sachs",
            "Morgan Stanley", "U.S. Bancorp", "PNC Financial Services", "Truist Financial", "Capital One Financial",
            "Charles Schwab", "Fifth Third Bancorp", "Ally Financial", "KeyCorp", "Regions Financial",
            "Huntington Bancshares", "First Republic Bank", "M&T Bank Corporation", "Citizens Financial", "Comerica",
            "Zions Bancorporation", "BOK Financial", "Synovus Financial", "Raymond James Financial", "SVB Financial",
            "First Horizon", "East West Bancorp", "New York Community Bancorp", "Wintrust Financial", "Western Alliance"
    };

    private final String[] queryNames = {
            "zipcode step 1 - T", "Phase 1 Retest", "ZipCode Step 2", "Phase3 test",
            "Rapid Daily Activity - AAID", "First Data Rapid Daily Activity Web Report HSBC",
            "Binary - Rapid Daily Activity Report 6056 - NDM", "ProductivityWork_Rpt",
            "Mailing SysPrin - T", "SPS - First Data Rapid Daily Activity Web Report",
            "First Data Rapid Activity Report", "SendToMIT", "Custom Excel Report",
            "Product Group Report", "Account Transfer Rejects Daily Report", "Amex Remail - 1"
            // 省略剩下部分，照你原来代码放...
    };

    private final Random random = new Random();

    public ClientDataGenerator(ClientRepository clientRepository, AdminQueryListRepository adminQueryListRepository, InvalidDelivAreaRepository invalidDelivAreaRepository) {
        this.clientRepository = clientRepository;
        this.adminQueryListRepository = adminQueryListRepository;
        this.invalidDelivAreaRepository = invalidDelivAreaRepository;
    }

    public void generateClients() {
        List<AdminQueryList> reports = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            AdminQueryList report = new AdminQueryList();
            report.setDefaultFileNm("Report " + j);
            report.setReportByClientFlag(random.nextInt(2) == 1);
            report.setDbDriverType("SQL Server");
            report.setQueryName(queryNames[random.nextInt(queryNames.length)]);
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

        for (int i = 0; i < usBanks.length; i++) {
            String clientId = String.valueOf(i + 1);
            String city = sampleCities[random.nextInt(sampleCities.length)];
            String state = usStates[random.nextInt(usStates.length)];
            String zip = String.format("%05d", 10000 + random.nextInt(89999));
            String phone = "555-" + (1000000 + random.nextInt(8999999));
            String name = usBanks[i];

            List<ClientReportOption> reportOptions = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                ClientReportOption option = new ClientReportOption();
                option.setId(new ClientReportOptionId());
                option.getId().setClientId(clientId);
                option.getId().setReportId(j);
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
                String cacheKey = clientId + "-" + atmCashRule + "-" + prefixStr;

                SysPrinsPrefix existingPrefix = prefixCache.get(cacheKey);
                if (existingPrefix == null) {
                    SysPrinsPrefixId prefixId = new SysPrinsPrefixId();
                    prefixId.setBillingSp(clientId);
                    prefixId.setAtmCashRule(atmCashRule);
                    prefixId.setPrefix(prefixStr);

                    SysPrinsPrefix newPrefix = new SysPrinsPrefix();
                    newPrefix.setId(prefixId);

                    prefixCache.put(cacheKey, newPrefix);
                    prefixes.add(newPrefix);
                } else {
                    prefixes.add(existingPrefix);
                }
            }

            List<SysPrin> sysPrinsList = new ArrayList<>();
            int sysPrinCount = 2 + random.nextInt(4);
            for (int s = 1; s <= sysPrinCount; s++) {
                SysPrin sysPrin = new SysPrin();
                SysPrinId sysPrinId = new SysPrinId();
                sysPrinId.setClient(clientId);
                sysPrinId.setSysPrin("SP" + (i + 1) + s);
                sysPrin.setId(sysPrinId);
                sysPrin.setCustType(random.nextInt(3));
                sysPrin.setUndeliverable("0");
                sysPrin.setStatA("1");
                sysPrin.setStatB("0");
                sysPrin.setStatC("1");
                sysPrin.setPoBox("0");
                sysPrin.setAddrFlag("Y");
                sysPrin.setTempAway(100L + s);
                sysPrin.setRps("Y");
                sysPrin.setSession("A");
                sysPrin.setBadState("0");
                sysPrin.setAStatRch("1");
                sysPrin.setNm13("0");
                sysPrin.setTempAwayAtts(200L + s);
                sysPrin.setReportMethod(0.0);
                sysPrin.setActive(true);
                sysPrin.setNotes("Note" + s);
                sysPrin.setReturnStatus("A");
                sysPrin.setDestroyStatus("0");
                sysPrin.setSpecial("1");
                sysPrin.setPinMailer("0");
                sysPrin.setHoldDays(10);
                sysPrin.setNonUS("0");
                sysPrin.setForwardingAddress("1");

                String sysPrinCode = sysPrin.getId().getSysPrin();
                List<InvalidDelivArea> invalidAreas = new ArrayList<>();
                for (int a = 1; a <= 5; a++) {
                    String randomState = usStates[random.nextInt(usStates.length)];
                    InvalidDelivArea area = new InvalidDelivArea(new InvalidDelivAreaId(sysPrinCode, randomState));
                    invalidAreas.add(area);
                }
                invalidDelivAreaRepository.saveAll(invalidAreas);

                sysPrin.setClient(null); // 先null，后面再统一设置
                sysPrinsList.add(sysPrin);
            }

            // Step 1: New Client (先new client)
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
                    "BILL" + (i + 1),
                    (i + 1) % 2,
                    (i + 1) % 3,
                    (i + 1) % 2 == 0,
                    (i + 1) % 2 == 1,
                    (i + 1) % 2,
                    "" + (i + 1),
                    (i + 1) % 2 == 0,
                    reportOptions,
                    prefixes,
                    sysPrinsList,
                    new ArrayList<>()
            );

            // Step 2: Generate emails and set client
            List<ClientEmail> emails = new ArrayList<>();
            for (int e = 1; e <= 3 + random.nextInt(3); e++) {
                ClientEmail email = new ClientEmail();
                ClientEmailId emailId = new ClientEmailId();
                emailId.setClientId(clientId);
                emailId.setEmailAddressTx("user" + e + "@example.com");
                email.setId(emailId);
                email.setReportId((long) (1 + random.nextInt(5)));
                email.setEmailNameTx("User" + e);
                email.setCarbonCopyFlag(e % 2 == 0);
                email.setActiveFlag(true);
                email.setMailServerId((long) random.nextInt(2));
                email.setClient(client); // 关键行！！
                emails.add(email);
            }
            client.setClientEmails(emails);

            // Step 3: sysPrins set client
            sysPrinsList.forEach(sp -> sp.setClient(client));

            // Step 4: Add to final list
            clients.add(client);
        }

        clientRepository.saveAll(clients);
    }
}
