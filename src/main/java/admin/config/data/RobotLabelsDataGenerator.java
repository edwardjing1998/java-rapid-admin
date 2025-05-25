package admin.config.data;

import admin.model.RobotLabels;
import admin.model.RobotLabelsId;
import admin.repository.RobotLabelsRepository;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Component
public class RobotLabelsDataGenerator {

    private final RobotLabelsRepository repository;

    public RobotLabelsDataGenerator(RobotLabelsRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void generateSampleData() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
            RobotLabels record = new RobotLabels();
            RobotLabelsId id = new RobotLabelsId(generateUserName(i), LocalDateTime.now().minusDays(i));
            record.setId(id);
            record.setBundles(i * 10);  // Example: 10, 20, ..., 300
            record.setIndividualLabels(i * 100);  // Example: 100, 200, ..., 3000
            record.setRobotLabelTotal(i * 1000);  // Example: 1000, 2000, ..., 30000
            repository.save(record);
        });

        System.out.println("30 RobotLabels sample records inserted!");
    }

    private String generateUserName(int i) {
        // Generate a unique 25-character username with padding
        String base = "User" + i;
        return String.format("%-25s", base).substring(0, 25);  // pad or trim to exactly 25 chars
    }
}
