package admin.config.data;

import admin.model.*;
import admin.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

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

        for (int i = 1; i <= 10; i++) {
            String clientId = "CLIENT" + i;
            String city = sampleCities[random.nextInt(sampleCities.length)];
            String state = usStates[random.nextInt(usStates.length)];
            String zip = String.format("%05d", 10000 + random.nextInt(89999));
            String phone = "555-" + (1000000 + random.nextInt(8999999));
            String name = "Client Name " + i;

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

            String billingSp = "BILL" + i;

            List<SysPrinsPrefix> prefixes = new ArrayList<>();
            for (int k = 1; k <= 5 + random.nextInt(5); k++) {
                SysPrinsPrefix prefix = new SysPrinsPrefix();
                prefix.setPrefix("prefixSP" + i + "_" + k + "_" + billingSp);
                prefix.setAtmCashRule(random.nextBoolean() ? "Destroy" : "Return");
                prefix.setBillingSp(billingSp);
                prefixes.add(prefix);
            }

            List<SysPrin> sysPrinsList = new ArrayList<>();
            int sysPrinCount = 2 + random.nextInt(4);
            for (int s = 1; s <= sysPrinCount; s++) {
                SysPrin sysPrin = new SysPrin();
                SysPrinId sysPrinId = new SysPrinId();
                sysPrinId.setClient(clientId);
                sysPrinId.setSysPrin("SP" + i + s);
                sysPrin.setId(sysPrinId);

                sysPrin.setCustType("Type" + s);
                sysPrin.setStartDate("2024-01-0" + s);
                sysPrin.setUndeliverable("N");

                sysPrin.setStatA("A" + s);
                sysPrin.setStatB("B" + s);
                sysPrin.setStatC("C" + s);
                sysPrin.setStatD("D" + s);
                sysPrin.setStatE("E" + s);
                sysPrin.setStatF("F" + s);
                sysPrin.setStatG("G" + s);
                sysPrin.setStatH("H" + s);
                sysPrin.setStatI("I" + s);
                sysPrin.setStatJ("J" + s);
                sysPrin.setStatK("K" + s);
                sysPrin.setStatL("L" + s);
                sysPrin.setStatM("M" + s);
                sysPrin.setStatN("N" + s);
                sysPrin.setStatO("O" + s);
                sysPrin.setStatP("P" + s);
                sysPrin.setStatQ("Q" + s);
                sysPrin.setStatR("R" + s);
                sysPrin.setStatS("S" + s);
                sysPrin.setStatT("T" + s);
                sysPrin.setStatU("U" + s);
                sysPrin.setStatV("V" + s);
                sysPrin.setStatW("W" + s);
                sysPrin.setStatX("X" + s);
                sysPrin.setStatY("Y" + s);
                sysPrin.setStatZ("Z" + s);

                sysPrin.setPoBox("Box" + s);
                sysPrin.setNoRenewal("N");
                sysPrin.setBlockCard("B");
                sysPrin.setAddrFlag("Y");

                sysPrin.setTempAway(100L + s);
                sysPrin.setRsp("RSP" + s);
                sysPrin.setSession("Session" + s);
                sysPrin.setBadState("No");
                sysPrin.setAStatRch("RCH" + s);
                sysPrin.setNm13("NM13" + s);
                sysPrin.setTempAwayAtts(200L + s);
                sysPrin.setReportMethod("Email");
                sysPrin.setContact("Contact" + s);
                sysPrin.setPhone("555-000" + s);
                sysPrin.setActive(random.nextBoolean() ? "Y" : "N");
                sysPrin.setNotes("Note" + s);
                sysPrin.setReturnStatus("R" + s);
                sysPrin.setDestroyStatus("D" + s);
                sysPrin.setNonUS("N");

                sysPrin.setClient(null);

                sysPrinsList.add(sysPrin);
            }

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
                    "Fax-" + i,
                    billingSp,
                    i % 2,
                    i % 3,
                    i % 2 == 0,
                    i % 2 == 1,
                    i % 2,
                    "XREF" + i,
                    i % 2 == 0,
                    reportOptions,
                    prefixes,
                    sysPrinsList
            );

            reportOptions.forEach(opt -> opt.setClient(client));
            sysPrinsList.forEach(sp -> sp.setClient(client));

            clients.add(client);
        }

        clientRepository.saveAll(clients);
    }
}
