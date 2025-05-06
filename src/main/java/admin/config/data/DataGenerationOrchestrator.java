package admin.config.data;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DataGenerationOrchestrator {

    private final ClientDataGenerator clientDataGenerator;
    private final CaseDataGenerator caseDataGenerator;

    private final DailyMessageDataGenerator dailyMessageDataGenerator;

    private final C3FileTransferDataGenerator c3FileTransferDataGenerator;

    public DataGenerationOrchestrator(ClientDataGenerator clientDataGenerator, CaseDataGenerator caseDataGenerator, DailyMessageDataGenerator dailyMessageDataGenerator, C3FileTransferDataGenerator c3FileTransferDataGenerator) {
        this.clientDataGenerator = clientDataGenerator;
        this.caseDataGenerator = caseDataGenerator;
        this.dailyMessageDataGenerator = dailyMessageDataGenerator;
        this.c3FileTransferDataGenerator = c3FileTransferDataGenerator;
    }

    @PostConstruct
    public void runDataGeneration() {

        // Generate clients and sysPrins first
        clientDataGenerator.generateClients();

        // Then generate cases (requires sysPrins to be ready)
        caseDataGenerator.generateCases();

        dailyMessageDataGenerator.generateDailyMessages();
        c3FileTransferDataGenerator.generateData();
    }
}
