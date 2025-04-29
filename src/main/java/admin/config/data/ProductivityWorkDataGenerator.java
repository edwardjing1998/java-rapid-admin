package admin.config.data;

import admin.model.Client;
import admin.model.ProductivityWork;
import admin.repository.ClientRepository;
import admin.repository.ProductivityWorkRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductivityWorkDataGenerator {

    private final ProductivityWorkRepository productivityWorkRepository;
    private final ClientRepository clientRepository;
    private final Random random = new Random();

    private final String[] names = {
            "alice", "bob", "charlie", "david", "eve",
            "frank", "grace", "henry", "irene", "jack"
    };

    public ProductivityWorkDataGenerator(ProductivityWorkRepository productivityWorkRepository,
                                         ClientRepository clientRepository) {
        this.productivityWorkRepository = productivityWorkRepository;
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    public void generateProductivityWorkData() {
        List<Client> clients = clientRepository.findAll();
        List<ProductivityWork> records = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime firstDayOfThisMonth = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime firstDayOfLastMonth = firstDayOfThisMonth.minusMonths(1);
        LocalDateTime lastDayOfLastMonth = firstDayOfThisMonth.minusNanos(1);

        int totalUsers = 20; // match user count from UserDataGenerator

        for (int userIndex = 1; userIndex <= totalUsers; userIndex++) {
            String userId = "user" + userIndex;
            String userName = names[userIndex % names.length].toUpperCase();

            for (Client client : clients) {
                for (int i = 1; i <= 2; i++) { // Generate fewer records per user/client pair
                    ProductivityWork pw = new ProductivityWork();

                    pw.getId().setUserId(userId);
                    pw.setUserName(userName);

                    pw.getId().setFromDate(randomDateBetween(firstDayOfLastMonth, lastDayOfLastMonth));
                    pw.setToDate(randomDateBetween(firstDayOfThisMonth, now));

                    pw.setMailedCount(randInt());
                    pw.setMailedTime(randInt());
                    pw.setMailedCards(randInt());

                    pw.setReturnedCount(randInt());
                    pw.setReturnedTime(randInt());
                    pw.setReturnedCards(randInt());

                    pw.setDestroyedCount(randInt());
                    pw.setDestroyedTime(randInt());
                    pw.setDestroyedCards(randInt());

                    pw.setHoldCount(randInt());
                    pw.setHoldTime(randInt());
                    pw.setHoldCards(randInt());

                    pw.setResearchCount(randInt());
                    pw.setResearchTime(randInt());
                    pw.setResearchCards(randInt());

                    pw.setPaymentCount(randInt());
                    pw.setPaymentTime(randInt());
                    pw.setPaymentCards(randInt());

                    pw.setAddressCount(randInt());
                    pw.setAddressTime(randInt());
                    pw.setAddressCards(randInt());

                    pw.setCorresCount(randInt());
                    pw.setCorresTime(randInt());
                    pw.setCorresCards(randInt());

                    pw.setBulkDestCount(randInt());
                    pw.setBulkDestTime(randInt());
                    pw.setBulkDestCards(randInt());

                    pw.setBulkRetCount(randInt());
                    pw.setBulkRetTime(randInt());
                    pw.setBulkRetCards(randInt());

                    pw.setSpecialCount(randInt());
                    pw.setSpecialCards(randInt());
                    pw.setSpecialTime(randInt());

                    pw.setPrivateLabelCount(randInt());
                    pw.setPrivateLabelTime(randInt());
                    pw.setPrivateLabelCards(randInt());

                    pw.setMetalCardCount(randInt());
                    pw.setMetalCardTime(randInt());
                    pw.setMetalCards(randInt());

                    pw.setRobotLabelTotal(randInt());

                    records.add(pw);
                }
            }
        }

        productivityWorkRepository.saveAll(records);
    }

    private int randInt() {
        return random.nextInt(100);
    }

    private LocalDateTime randomDateBetween(LocalDateTime start, LocalDateTime end) {
        long startEpoch = start.toEpochSecond(java.time.ZoneOffset.UTC);
        long endEpoch = end.toEpochSecond(java.time.ZoneOffset.UTC);
        long randomEpoch = startEpoch + (long) (random.nextDouble() * (endEpoch - startEpoch));
        return LocalDateTime.ofEpochSecond(randomEpoch, 0, java.time.ZoneOffset.UTC);
    }
}
