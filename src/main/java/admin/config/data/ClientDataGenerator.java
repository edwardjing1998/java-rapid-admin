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

    private final String[] queryNames = {
            "zipcode step 1 - T", "Phase 1 Retest", "ZipCode Step 2", "Phase3 test",
            "Rapid Daily Activity - AAID", "First Data Rapid Daily Activity Web Report HSBC",
            "Binary - Rapid Daily Activity Report 6056 - NDM", "ProductivityWork_Rpt",
            "Mailing SysPrin - T", "SPS - First Data Rapid Daily Activity Web Report",
            "First Data Rapid Activity Report", "SendToMIT", "Custom Excel Report",
            "Product Group Report", "Account Transfer Rejects Daily Report", "Amex Remail - 1",
            "Phase 1 Test", "Create Robot Queue", "Unworked Robot Cases", "Rapid Hold Cases",
            "Clear Cycle Tracking", "Daily Billing Mail Report", "Billing Mail Report",
            "Daily Mail List", "Mail List", "Daily Mail Summary", "Mail Summary",
            "Operator Code List", "List Excluded From Postage Reports", "BenchmarkResults",
            "Rapid Daily Activity Report - NDM", "First Data Rapid Daily Activity Report",
            "Rapid Research Cases", "Queued for Return Cases", "Queued for Destroy cases",
            "Hold Date Expired Cases", "Number of New Cases for Day", "BenchmarkResults",
            "Binary -  Rapid Daily Activity Report - NDM", "Amex Remail Cases Web",
            "Amex Memo Cases Web", "First Data Rapid Activity Special",
            "First Data Custom Rapid Daily Activity (AMEX)", "SLA Report (Web)", "DHL Cases",
            "First Data Rapid Activity Report", "TeleServices Cases Web", "Rapid Titanium Report",
            "FedEx Cases", "Check For Deleted Account", "Rapid Daily Activity Report LH1",
            "Rapid Daily Activity Report TNB", "Rapid Daily Activity Report ECnt",
            "Mail Compliance Report", "Return Query", "Amex Worked w/o D/R", "Amex Worked w/ D/R",
            "PSCU RAPID CUSTOM WEB REPORT", "SLA Report", "MasterCard Daily Count",
            "Visa Daily Count", "Amex Daily Count", "Pin Mailer User", "ATM Billing Report",
            "Pin Mailer Billing Report", "MasterCard Visa not Closed - Del Cases After Addr",
            "Delete Sys Prins by Client Id", "Select Sys Prins by Client Id",
            "MasterCard Visa not Closed - Del Addr before Cases",
            "DELETE All Transactions For A Client", "SELECT All Transactions To Delete For A Client",
            "PinMailer", "Rapid Extract Monthly Billing Report", "Pin Mailer Load",
            "Rapid CleanUp Unmatched Sys Prins", "Account Transfer Rejects Daily Report",
            "View Rapid Sys_prin_billing Table", "INVALID SYS PRINS UPDATE",
            "SYS PRIN LOAD COUNTS", "INVALID SYS PRINS", "Clean Up TRANS With Auto Date 01/01/1900",
            "UPS Cases", "View Sys Prins Table By System Only", "View Client Change Log",
            "View Sys Prin Change Log", "Case Activity 7th thru 24th Month",
            "Case Activity 4th thru 6th Month", "Case Activity 1st thru 3rd Month",
            "Amex Not Closed", "MasterCard Visa not Closed", "First Data Rapid Daily Activity Web Report",
            "MITAA File", "RapidMonthlyBillingRpt", "ConnectPayRpt7012", "User ID List",
            "Quarterly User Verification", "Rapid3QrtrlyUserVerification", "Set Rapid3 Users To Inactive",
            "Rapid3 System Prin Billing", "Rapid3 System Prin Billing Archive",
            "Rapid3_Archive System Prin Billing Archive", "Amex Custom Destroy Report",
            "Monthly Billing Report - Totals by client", "OFL ClientCases Daily Web Report",
            "OFL Client Cases Daily Admin Report", "PayPalDailyPrivateLabelRpt", "CAP1 Daily File",
            "OFL Client Cases - DELETE", "OFL Client Cases - VIEW TOTALS BY DAY",
            "CAP1-Email-Step1", "CAP1-Email-Step2", "CAP1Email", "CAP1-Email-Final-Cleanup",
            "CAP1-Email-Step2-TUES", "CAP1Email-Tues", "CAP1-Email-Step1-Tues",
            "CAP1-Email-Final-Cleanup-Tues", "SendToSolutions", "ReceiveFromSolutions",
            "Rapid Admin Query List", "Pin Mailer Totals", "ATM/Cash Card Totals",
            "Check Open Cases By Sys/Prin", "TeleServices Cases", "Amex Memo Cases",
            "Amex Remail Cases", "Solution Cases", "ABC letters Cases", "Vendor Cases",
            "BulkCard Cases", "List Robot Labels", "RapidMonthlyPinMailerBillingRpt",
            "RESET Master Codes for  Reporting", "RESET Master Codes for  Daily Processing",
            "CAP1 - Prepend Zeroes to Account Number", "CAP1 - Reset Process Date",
            "First Data Rapid Daily Activity Web Report 5620", "Vendor Sent To Maintenance",
            "NCOA Processing: Remove Client", "NCOA Processing: View Client",
            "Rapid Daily Activity Report CL5596", "Rapid Daily Activity Report CL5642",
            "Rapid Daily Activity Report CL5685", "Amex Custom Destroy Report 375",
            "SolutionsRobotFile", "Amex Custom Destroy Report1", "Amex Billing", "Amex Cases",
            "Mailing SysPrin", "Amex Remail", "BulkCards", "ZipCode Step 1"
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
            int randomBit = random.nextInt(2);  // 0 or 1
            report.setReportByClientFlag(randomBit == 1); // 1 → true, 0 → false
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
                option.setOutputTypeCd(random.nextInt(3)); // 0 (None), 1 (File), or 2 (Print)
                option.setFileTypeCd(random.nextInt(3));  // 0 (None), 1 (Text), or 2 (Excel)
                option.setEmailFlag(random.nextInt(3));  // 0 (None), 1 (Email), or 2 (Web)
                option.setReportPasswordTx("pass" + j);
                option.setReport(reports.get((j - 1) % reports.size()));
                option.setEmailBodyTx("Email body for " + clientId + " item  " + j);
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
                sysPrinId.setSysPrin("SP" + (i + 1) + s);
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
                    String randomState = usStates[random.nextInt(usStates.length)];
                    InvalidDelivArea area = new InvalidDelivArea(new InvalidDelivAreaId(sysPrinCode, randomState));
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
