package admin.service;

import admin.dto.BulkDestSummaryDTO;
import admin.dto.ProductivityWorkDTO;
import admin.model.ProductivityWork;
import admin.repository.ProductivityWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductivityWorkService {

    private final ProductivityWorkRepository repository;

    @Autowired
    public ProductivityWorkService(ProductivityWorkRepository repository) {
        this.repository = repository;
    }

    public List<ProductivityWorkDTO> getAllRecords() {
        return repository.findAll().stream()
                .map(this::toFullDTO)
                .toList();
    }

    public List<ProductivityWorkDTO> getSelectedFieldsByAllUsers(LocalDateTime fromDate, LocalDateTime toDate) {
        return repository.findAllValidProductivityWork(fromDate, toDate).stream()
                .map(this::toFullDTO)
                .toList();
    }

    public List<ProductivityWorkDTO> getRecordsByUserId(String userId, LocalDateTime fromDate, LocalDateTime toDate) {
        return repository.findValidProductivityWorkByUser(userId, fromDate, toDate).stream()
                .map(this::toFullDTO)
                .toList();
    }

    private ProductivityWorkDTO toFullDTO(ProductivityWork entity) {
        ProductivityWorkDTO dto = new ProductivityWorkDTO();
        dto.setUserId(entity.getId().getUserId());
        dto.setUserName(entity.getUserName());
        dto.setFromDate(entity.getId().getFromDate());
        dto.setToDate(entity.getToDate());

        dto.setMailedCount(entity.getMailedCount());
        dto.setMailedTime(entity.getMailedTime());
        dto.setMailedCards(entity.getMailedCards());

        dto.setReturnedCount(entity.getReturnedCount());
        dto.setReturnedTime(entity.getReturnedTime());
        dto.setReturnedCards(entity.getReturnedCards());

        dto.setDestroyedCount(entity.getDestroyedCount());
        dto.setDestroyedTime(entity.getDestroyedTime());
        dto.setDestroyedCards(entity.getDestroyedCards());

        dto.setHoldCount(entity.getHoldCount());
        dto.setHoldTime(entity.getHoldTime());
        dto.setHoldCards(entity.getHoldCards());

        dto.setResearchCount(entity.getResearchCount());
        dto.setResearchTime(entity.getResearchTime());
        dto.setResearchCards(entity.getResearchCards());

        dto.setPaymentCount(entity.getPaymentCount());
        dto.setPaymentTime(entity.getPaymentTime());
        dto.setPaymentCards(entity.getPaymentCards());

        dto.setAddressCount(entity.getAddressCount());
        dto.setAddressTime(entity.getAddressTime());
        dto.setAddressCards(entity.getAddressCards());

        dto.setCorresCount(entity.getCorresCount());
        dto.setCorresTime(entity.getCorresTime());
        dto.setCorresCards(entity.getCorresCards());

        dto.setBulkDestCount(entity.getBulkDestCount());
        dto.setBulkDestTime(entity.getBulkDestTime());
        dto.setBulkDestCards(entity.getBulkDestCards());

        dto.setBulkRetCount(entity.getBulkRetCount());
        dto.setBulkRetTime(entity.getBulkRetTime());
        dto.setBulkRetCards(entity.getBulkRetCards());

        dto.setSpecialCount(entity.getSpecialCount());
        dto.setSpecialCards(entity.getSpecialCards());
        dto.setSpecialTime(entity.getSpecialTime());

        dto.setPrivateLabelCount(entity.getPrivateLabelCount());
        dto.setPrivateLabelTime(entity.getPrivateLabelTime());
        dto.setPrivateLabelCards(entity.getPrivateLabelCards());

        dto.setMetalCardCount(entity.getMetalCardCount());
        dto.setMetalCardTime(entity.getMetalCardTime());
        dto.setMetalCards(entity.getMetalCards());

        dto.setRobotLabelTotal(entity.getRobotLabelTotal());

        return dto;
    }

    public BulkDestSummaryDTO getBulkDestSummary() {
        BulkDestSummaryDTO result = repository.getBulkDestSummary();
        Long bulkDestCount = result != null ? ((Number) result.getBulkdestAccounts()).longValue() : 0L;
        Long bulkDestCards = result != null ? ((Number) result.getBulkdestAccounts()).longValue() : 0L;
        return new BulkDestSummaryDTO(bulkDestCount, bulkDestCards);
    }
}
