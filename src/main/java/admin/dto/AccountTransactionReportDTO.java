package admin.dto;

import java.time.LocalDateTime;

public interface AccountTransactionReportDTO {
    String getCaseNumber();
    String getActionReason();
    LocalDateTime getDateTime();
    String getPiId();
    String getAccount();
    String getLastName();
    String getFirstName();
    String getAddr1Tx();
    String getAddr2Tx();
    String getCityTx();
    String getStateTx();
    String getZipCd();
    String getSysPrin();
    String getClient();
    String getName(); // client name
}
