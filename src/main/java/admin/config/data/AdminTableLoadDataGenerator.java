package admin.config.data;

import admin.model.AdminTableLoad;
import admin.repository.AdminTableLoadRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("local")
public class AdminTableLoadDataGenerator {

    private final AdminTableLoadRepository adminTableLoadRepository;

    public AdminTableLoadDataGenerator(AdminTableLoadRepository adminTableLoadRepository) {
        this.adminTableLoadRepository = adminTableLoadRepository;
    }

    @PostConstruct
    public void generateAdminTableLoads() {
        List<AdminTableLoad> adminTableLoads = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            AdminTableLoad atl = new AdminTableLoad();
            atl.setReportId(i);
            atl.setTableName("table_" + i);
            atl.setDbServer("dbserver" + i);
            atl.setDbIpAndPort("192.168.1." + i + ":5432");
            atl.setPassWord("password" + i);
            atl.setUserId("user" + i);
            atl.setDatabase("testdb" + i);
            atl.setDbDriver("org.h2.Driver");

            adminTableLoads.add(atl);
        }

        adminTableLoadRepository.saveAll(adminTableLoads);
    }
}
