package admin.repository;

import admin.model.DailyMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DailyMessageRepository extends JpaRepository<DailyMessage, LocalDateTime> {

    // Example custom method to find messages between two dates
    List<DailyMessage> findByMessageDateBetween(LocalDateTime start, LocalDateTime end);
}
