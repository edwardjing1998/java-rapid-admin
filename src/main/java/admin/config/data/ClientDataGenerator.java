package admin.config.data;

import admin.model.*;
import admin.repository.AdminQueryListRepository;
import admin.repository.ClientRepository;
import admin.repository.InvalidDelivAreaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class ClientDataGenerator {

    private final ClientRepository clientRepository;
    private final AdminQueryListRepository adminQueryListRepository;

    private final CaseDataGenerator caseDataGenerator;

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
            "Huntington Bancshares", "First Republic Bank", "M&T Bank Corporation", "Citizens Financial Group", "Comerica",
            "Zions Bancorporation", "BOK Financial", "Synovus Financial", "Raymond James Financial", "SVB Financial Group",
            "First Horizon", "East West Bancorp", "New York Community Bancorp", "Wintrust Financial", "Western Alliance Bancorporation"
    };

    private final Random random = new Random();

    private InvalidDelivArea area = new InvalidDelivArea();


    public ClientDataGenerator(ClientRepository clientRepository, AdminQueryListRepository adminQueryListRepository,
                               CaseDataGenerator caseDataGenerator, InvalidDelivAreaRepository invalidDelivAreaRepository) {
        this.clientRepository = clientRepository;
        this.adminQueryListRepository = adminQueryListRepository;
        this.caseDataGenerator = caseDataGenerator;
        this.invalidDelivAreaRepository = invalidDelivAreaRepository;
    }

    public void generateClients() {
        List<AdminQueryList> reports = new ArrayList<>();
        for (int j = 1; j <= 5; j++) {
            AdminQueryList report = new AdminQueryList();
            report.setReportName("Report " + j);
            report.setReportByClientFlag(1);
            reports.add(report);
        }
        adminQueryListRepository.saveAll(reports);

        List<Client> clients = new ArrayList<>();

        for (int i = 0; i < usBanks.length; i++) {
            String clientId = "CLIENT" + (i + 1);
            String city = sampleCities[random.nextInt(sampleCities.length)];
            String state = usStates[random.nextInt(usStates.length)];
            String zip = String.format("%05d", 10000 + random.nextInt(89999));
            String phone = "555-" + (1000000 + random.nextInt(8999999));
            String name = usBanks[i];

            List<ClientReportOption> reportOptions = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                ClientReportOption option = new ClientReportOption();
                option.setReportId((long) j);
                option.setReceiveFlag(j % 2 == 0);
                option.setOutputTypeCd(random.nextBoolean() ? "File" : "Print");
                option.setFileTypeCd(random.nextBoolean() ? "Text" : "Excel");
                option.setEmailFlag(j % 3);
                option.setReportPasswordTx("pass" + j);
                option.setReport(reports.get(j - 1));
                reportOptions.add(option);
            }

            String billingSp = "BILL" + (i + 1);

            List<SysPrinsPrefix> prefixes = new ArrayList<>();
            for (int k = 1; k <= 5 + random.nextInt(5); k++) {
                SysPrinsPrefix prefix = new SysPrinsPrefix();
                prefix.setPrefix("prefixSP" + (i + 1) + "_" + k + "_" + billingSp);
                prefix.setAtmCashRule(random.nextBoolean() ? "Destroy" : "Return");
                prefix.setBillingSp(billingSp);
                prefixes.add(prefix);
            }

            List<String> detailedStatuses = Arrays.asList("Destroy", "Return", "Research / Destroy", "Research / Return", "Research / Carrier Ret");
            List<String> shortStatuses = Arrays.asList("Destroy", "Return");

            List<SysPrin> sysPrinsList = new ArrayList<>();
            int sysPrinCount = 2 + random.nextInt(4);
            for (int s = 1; s <= sysPrinCount; s++) {
                SysPrin sysPrin = new SysPrin();
                SysPrinId sysPrinId = new SysPrinId();
                sysPrinId.setClient(clientId);
                sysPrinId.setSysPrin("SP" + (i + 1) + s + " for " + clientId + " - " + name);
                sysPrin.setId(sysPrinId);

                String[] custTypes = {"Full Processing", "Destroy All", "Return All"};
                sysPrin.setCustType(custTypes[random.nextInt(custTypes.length)]);
                sysPrin.setUndeliverable(detailedStatuses.get(random.nextInt(detailedStatuses.size())));

                sysPrin.setStatA(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatB(shortStatuses.get(random.nextInt(shortStatuses.size())));
                sysPrin.setStatC(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatD(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatE(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatF(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatI(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatL(shortStatuses.get(random.nextInt(shortStatuses.size())));
                sysPrin.setStatO(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatU(shortStatuses.get(random.nextInt(shortStatuses.size())));
                sysPrin.setStatX(detailedStatuses.get(random.nextInt(detailedStatuses.size())));
                sysPrin.setStatZ(shortStatuses.get(random.nextInt(shortStatuses.size())));

                sysPrin.setPoBox("Return");
                sysPrin.setAddrFlag(random.nextBoolean() ? "Y" : "N");
                sysPrin.setTempAway(100L + s);
                sysPrin.setRps(random.nextBoolean() ? "Y" : "N");
                sysPrin.setSession("Session" + s);
                sysPrin.setBadState("Return");
                sysPrin.setAStatRch(random.nextBoolean() ? "Y" : "N");
                sysPrin.setNm13(random.nextBoolean() ? "Y" : "N");
                sysPrin.setTempAwayAtts(200L + s);
                sysPrin.setReportMethod("Email");
                sysPrin.setActive("Y");
                sysPrin.setNotes("Note" + s);
                String[] returnStatuses = {"A Status", "C Status", "E Status", "F Status"};
                sysPrin.setReturnStatus(returnStatuses[random.nextInt(returnStatuses.length)]);

                String[] destroyStatuses = {"Destroy", "Return"};
                sysPrin.setDestroyStatus(destroyStatuses[random.nextInt(destroyStatuses.length)]);

                String[] specialOptions = {"Destroy", "Return"};
                sysPrin.setSpecial(specialOptions[random.nextInt(specialOptions.length)]);

                String[] pinMailerOptions = {"Destroy", "Return"};
                sysPrin.setPinMailer(pinMailerOptions[random.nextInt(pinMailerOptions.length)]);

                sysPrin.setHoldDays(10);
                sysPrin.setNonUS("Return");
                String[] forwardingAddressOptions = {"Re-Mail", "Research"};
                sysPrin.setForwardingAddress(forwardingAddressOptions[random.nextInt(forwardingAddressOptions.length)]);

                String sysPrinCode = sysPrin.getId().getSysPrin(); // get the String identifier

                List<InvalidDelivArea> invalidAreas = new ArrayList<>();
                for (int a = 1; a <= 5; a++) {
                    String invalid_city = sampleCities[random.nextInt(sampleCities.length)];
                    String invalid_state = usStates[random.nextInt(usStates.length)];
                    String invalid_zip = String.format("%05d", 10000 + random.nextInt(89999));

                    InvalidDelivArea area = new InvalidDelivArea();
                    area.setArea(invalid_city + ", " + invalid_state + " " + invalid_zip);
                    area.setSysPrin(sysPrinCode); // manually assign sysPrin code (string)
                    invalidAreas.add(area);
                }

                invalidDelivAreaRepository.saveAll(invalidAreas);

                sysPrin.setClient(null);
                sysPrinsList.add(sysPrin);
            }

            List<ClientEmail> emails = new ArrayList<>();
            for (int e = 1; e <= 3 + random.nextInt(3); e++) {
                ClientEmail email = new ClientEmail();
                email.setClientId(clientId);
                email.setReportId((long) (1 + random.nextInt(5)));
                email.setEmailName("User" + e);
                email.setEmailAddress("user" + e + "@example.com");
                email.setCarbonCopyFlag(e % 2 == 0);
                email.setActiveFlag(true);
                email.setMailServerId((long) random.nextInt(2));
                email.setCreatedAt(LocalDateTime.now());
                email.setUpdatedAt(LocalDateTime.now());
                emails.add(email);
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
                    "XREF" + (i + 1),
                    (i + 1) % 2 == 0,
                    reportOptions,
                    prefixes,
                    sysPrinsList,
                    emails
            );

            reportOptions.forEach(opt -> opt.setClient(client));
            sysPrinsList.forEach(sp -> sp.setClient(client));

            clients.add(client);
        }

        clientRepository.saveAll(clients);
    }
}
