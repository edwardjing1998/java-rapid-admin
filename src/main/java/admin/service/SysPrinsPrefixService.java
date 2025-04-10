// SysPrinsPrefixService.java
package admin.service;

import admin.dto.SysPrinsPrefixRequest;
import admin.model.SysPrinsPrefix;
import admin.repository.SysPrinsPrefixRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPrinsPrefixService {

    private final SysPrinsPrefixRepository repository;

    public SysPrinsPrefixService(SysPrinsPrefixRepository repository) {
        this.repository = repository;
    }

    @Transactional // ✅ This ensures a transaction is created for delete operation
    public void deleteByBillingSpAndPrefix(String billingSp, String prefix) {
        repository.deleteByBillingSpAndPrefix(billingSp, prefix);
    }

    public SysPrinsPrefix save(SysPrinsPrefixRequest request) {
        // Convert DTO to Entity
        SysPrinsPrefix entity = new SysPrinsPrefix();
        entity.setBillingSp(request.getBillingSp());
        entity.setPrefix(request.getPrefix());
        entity.setAtmCashRule(request.getAtmCashRule());

        return repository.save(entity);
    }
}
