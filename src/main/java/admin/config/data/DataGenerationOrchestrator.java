package admin.config.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataGenerationOrchestrator {

    private final ClientDataGenerator clientDataGenerator;
    private final CaseDataGenerator caseDataGenerator;

    public DataGenerationOrchestrator(ClientDataGenerator clientDataGenerator, CaseDataGenerator caseDataGenerator) {
        this.clientDataGenerator = clientDataGenerator;
        this.caseDataGenerator = caseDataGenerator;
    }

    @PostConstruct
    public void runDataGeneration() {
        // Generate clients and sysPrins first
        clientDataGenerator.generateClients();

        // Then generate cases (requires sysPrins to be ready)
        caseDataGenerator.generateCases();
    }
}
