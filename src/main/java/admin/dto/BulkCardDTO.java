package admin.dto;

import java.time.LocalDateTime;

public class BulkCardDTO {

    private String caseNumber;
    private String piId;
    private String bulkPiId;
    private LocalDateTime inDate;

    public BulkCardDTO() {
    }

    public BulkCardDTO(String caseNumber, String piId, String bulkPiId, LocalDateTime inDate) {
        this.caseNumber = caseNumber;
        this.piId = piId;
        this.bulkPiId = bulkPiId;
        this.inDate = inDate;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getBulkPiId() {
        return bulkPiId;
    }

    public void setBulkPiId(String bulkPiId) {
        this.bulkPiId = bulkPiId;
    }

    public LocalDateTime getInDate() {
        return inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    @Override
    public String toString() {
        return "BulkCardDTO{" +
                "caseNumber='" + caseNumber + '\'' +
                ", piId='" + piId + '\'' +
                ", bulkPiId='" + bulkPiId + '\'' +
                ", inDate=" + inDate +
                '}';
    }
}
