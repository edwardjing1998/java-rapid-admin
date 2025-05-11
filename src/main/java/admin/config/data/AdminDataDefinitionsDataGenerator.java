package admin.config.data;

import admin.model.AdminDataDefinitionsList;
import admin.repository.AdminDataDefinitionsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("local")
public class AdminDataDefinitionsDataGenerator {

    private final AdminDataDefinitionsRepository adminDataDefinitionsRepository;

    public AdminDataDefinitionsDataGenerator(AdminDataDefinitionsRepository adminDataDefinitionsRepository) {
        this.adminDataDefinitionsRepository = adminDataDefinitionsRepository;
    }

    @PostConstruct
    public void generateDataDefinitions() {
        List<AdminDataDefinitionsList> dataList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            AdminDataDefinitionsList d = new AdminDataDefinitionsList();
            d.setReportId(i);

            // Example values for lengths, masks, and types
            d.setInput0DataLength("in" + i);
            d.setInput1DataLength("in " + i);
            d.setInput2DataLength("in" + i);
            d.setInput3DataLength("in" + i);
            d.setInput4DataLength("in" + i);
            d.setInput5DataLength("in" + i);
            d.setInput6DataLength("in" + i);
            d.setInput7DataLength("in" + i);
            d.setInput8DataLength("in" + i);

            d.setInput0DataMask("MASK0_" + i);
            d.setInput1DataMask("MASK1_" + i);
            d.setInput2DataMask("MASK2_" + i);
            d.setInput3DataMask("MASK3_" + i);
            d.setInput4DataMask("MASK4_" + i);
            d.setInput5DataMask("MASK5_" + i);
            d.setInput6DataMask("MASK6_" + i);
            d.setInput7DataMask("MASK7_" + i);
            d.setInput8DataMask("MASK8_" + i);

            d.setInput0DataType("STRI");
            d.setInput1DataType("NUMB");
            d.setInput2DataType("DATE");
            d.setInput3DataType("STRI");
            d.setInput4DataType("NUMB");
            d.setInput5DataType("DATE");
            d.setInput6DataType("STRI");
            d.setInput7DataType("NUMB");
            d.setInput8DataType("DATE");

            dataList.add(d);
        }

        adminDataDefinitionsRepository.saveAll(dataList);
    }
}
