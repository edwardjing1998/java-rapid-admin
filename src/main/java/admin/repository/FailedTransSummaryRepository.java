package admin.repository;

import jakarta.persistence.Tuple;

import java.util.List;

public interface FailedTransSummaryRepository {
    public List<Tuple> findSummaryByType();
}
