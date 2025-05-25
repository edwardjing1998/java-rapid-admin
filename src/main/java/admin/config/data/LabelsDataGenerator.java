package admin.config.data;

import admin.model.Labels;
import admin.model.LabelsId;
import admin.repository.LabelsRepository;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class LabelsDataGenerator {

    private final LabelsRepository repository;

    public LabelsDataGenerator(LabelsRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void generateSampleData() {
        List<Labels> labelsList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Labels label = new Labels();
            LabelsId id = new LabelsId();
            id.setText1("TEXT1_SAMPLE_" + i);  // Max 50
            id.setText2("TEXT2_SAMPLE_" + i);  // Max 50
            id.setText3("TEXT3_SAMPLE_" + i);  // Max 50
            id.setText4("TEXT4_SAMPLE_" + i);  // Max 50
            id.setText5("TEXT5_SAMPLE_" + i);  // Max 50
            id.setStatus(i % 2 == 0);  // Alternate true/false
            id.setType("PRINT");  // Max 10
            id.setCaseNumber(String.format("%016d", i));  // Max 16 chars, padded with zeros
            id.setCardTypeTx("CT" + i);  // Max 7
            id.setBarCodeTx("BARCODE_" + String.format("%05d", i));  // Max 70
            id.setText3Addr3("ADDR3_SAMPLE_" + i);  // Max 50
            id.setText3Addr4("ADDR4_SAMPLE_" + i);  // Max 50
            label.setId(id);
            labelsList.add(label);
        }

        repository.saveAll(labelsList);
        System.out.println("Sample Labels data generated successfully.");
    }
}
