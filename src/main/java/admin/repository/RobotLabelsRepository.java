package admin.repository;

import admin.model.RobotLabels;
import admin.model.RobotLabelsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RobotLabelsRepository extends JpaRepository<RobotLabels, RobotLabelsId> {
    List<RobotLabels> findByIdUserName(String userName);
}
