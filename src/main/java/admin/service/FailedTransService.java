package admin.service;

import admin.repository.FailedTransRepository;
import org.springframework.stereotype.Service;

@Service
public class FailedTransService {

    private final FailedTransRepository repository;

    public FailedTransService(FailedTransRepository repository) {
        this.repository = repository;
    }

    public void deleteAllFailedTransactions() {
        repository.deleteAll();
    }
}
