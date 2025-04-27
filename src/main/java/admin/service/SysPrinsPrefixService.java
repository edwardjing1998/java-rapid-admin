// SysPrinsPrefixService.java
package admin.service;

import admin.dto.SysPrinsPrefixRequest;
import admin.model.SysPrinsPrefix;
import admin.model.SysPrinsPrefixId;
import admin.repository.SysPrinsPrefixRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysPrinsPrefixService {

    private final SysPrinsPrefixRepository repository;

    public SysPrinsPrefixService(SysPrinsPrefixRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void deleteByBillingSpPrefixAndAtmCashRule(String billingSp, String prefix, String atmCashRule) {
        SysPrinsPrefixId id = new SysPrinsPrefixId(billingSp, prefix, atmCashRule);
        repository.deleteById(id);
    }

    public SysPrinsPrefix save(SysPrinsPrefixRequest request) {
        SysPrinsPrefixId id = new SysPrinsPrefixId(
                request.getBillingSp(),
                request.getPrefix(),
                request.getAtmCashRule()
        );
        SysPrinsPrefix entity = new SysPrinsPrefix();
        entity.setId(id);
        return repository.save(entity);
    }
}
