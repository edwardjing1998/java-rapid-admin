package admin.dto;

public class BulkDestSummaryDTO {
    private Long bulkdestAccounts;
    private Long bulkdestCards;

    // ✅ Make sure this is declared as public
    public BulkDestSummaryDTO(Number bulkdestAccounts, Number bulkdestCards) {
        // Convert Number to Long to be safe
        this.bulkdestAccounts = bulkdestAccounts != null ? bulkdestAccounts.longValue() : 0L;
        this.bulkdestCards = bulkdestCards != null ? bulkdestCards.longValue() : 0L;
    }

    public Long getBulkdestAccounts() {
        return bulkdestAccounts;
    }

    public void setBulkdestAccounts(Long bulkdestAccounts) {
        this.bulkdestAccounts = bulkdestAccounts;
    }

    public Long getBulkdestCards() {
        return bulkdestCards;
    }

    public void setBulkdestCards(Long bulkdestCards) {
        this.bulkdestCards = bulkdestCards;
    }
}
