package admin.config.data;

import admin.model.User;
import admin.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class UserDataGenerator {

    private final UserRepository userRepository;
    private final Random random = new Random();

    private final String[] names = {
            "alice", "bob", "charlie", "david", "eve",
            "frank", "grace", "henry", "irene", "jack"
    };

    public UserDataGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void generateUsers() {
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            User user = new User();

            String userId = "user" + i;
            String userName = names[i % names.length].toUpperCase();
            String operatorCd = String.format("%02d", i % 99);

            user.setUserId(userId);
            user.setUserName(userName);
            user.setCurrentPassword("Current@123" + i);
            user.setAccessLevel(String.valueOf((char) ('A' + (i % 3))));
            user.setFdrid("FDR" + String.format("%05d", i));
            user.setFdrpwd("PWD" + String.format("%04d", i));
            user.setFdrpwdexp((short) (30 + i));
            user.setActive(i % 2 == 0);
            user.setOperatorCD(operatorCd);
            user.setLastLogonDate(LocalDateTime.now().minusDays(i));
            user.setReportGrpId("GRP" + (i % 5));
            user.setPassword("Secret" + i);

            // Set password history
            for (int j = 2; j <= 20; j++) {
                try {
                    var method = User.class.getMethod("setPassword" + j, String.class);
                    method.invoke(user, "History" + j + "_" + i);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to set password" + j, e);
                }
            }

            user.setTimedPassword(LocalDateTime.now().minusHours(i));
            user.setLogedIn(i % 3 == 0 ? "Y" : "N");

            users.add(user);
        }

        userRepository.saveAll(users);
    }
}
