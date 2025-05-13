package admin.config.data;

import admin.model.FailedTransWork;
import admin.model.FailedTransWorkId;
import admin.repository.FailedTransWorkRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FailedTransWorkDataGenerator {

    private final FailedTransWorkRepository repository;

    public FailedTransWorkDataGenerator(FailedTransWorkRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void insertSampleData() {
        repository.save(createSample("C1001", "PI01", "ACC01", 1, 0, "Invalid routing"));
        repository.save(createSample("C1002", "PI02", "ACC02", 0, 1, "Timeout"));
        repository.save(createSample("C1003", "PI03", "ACC03", 2, 3, "Insufficient funds"));
    }

    private FailedTransWork createSample(String caseNumber, String piId, String account, int nonMon, int retry, String message) {
        FailedTransWork entity = new FailedTransWork();
        entity.setId(new FailedTransWorkId(caseNumber, piId, account));
        entity.setDateTime(LocalDateTime.now());
        entity.setNonMon(nonMon);
        entity.setRetryCount(retry);
        entity.setMessage(message);
        return entity;
    }
}
