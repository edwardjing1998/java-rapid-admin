package admin.config.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataGenerationOrchestrator {

    private final ClientDataGenerator clientDataGenerator;
    private final CaseDataGenerator caseDataGenerator;

    private final DailyMessageDataGenerator dailyMessageDataGenerator;

    public DataGenerationOrchestrator(ClientDataGenerator clientDataGenerator, CaseDataGenerator caseDataGenerator, DailyMessageDataGenerator dailyMessageDataGenerator) {
        this.clientDataGenerator = clientDataGenerator;
        this.caseDataGenerator = caseDataGenerator;
        this.dailyMessageDataGenerator = dailyMessageDataGenerator;
    }

    @PostConstruct
    public void runDataGeneration() {
        // Generate clients and sysPrins first
        clientDataGenerator.generateClients();

        // Then generate cases (requires sysPrins to be ready)
        caseDataGenerator.generateCases();

        dailyMessageDataGenerator.generateDailyMessages();
    }
}
