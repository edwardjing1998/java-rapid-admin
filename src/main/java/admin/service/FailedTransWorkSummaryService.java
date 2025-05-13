package admin.service;

import admin.dto.FailedTransSummaryDTO;
import admin.repository.FailedTransSummaryRepositoryImpl;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FailedTransWorkSummaryService {

    private final FailedTransSummaryRepositoryImpl repository;

    public FailedTransWorkSummaryService(FailedTransSummaryRepositoryImpl repository) {
        this.repository = repository;
    }

    public List<FailedTransSummaryDTO> getFailedTransSummary() {
        List<Tuple> rows = repository.findSummaryByType();
        List<FailedTransSummaryDTO> result = new ArrayList<>();

        for (Tuple row : rows) {
            String caseNumber = row.get("caseNumber", String.class);
            String piId = row.get("piId", String.class);

            // Convert Timestamp to LocalDateTime safely
            LocalDateTime dateTime = null;
            Object dateTimeObj = row.get("dateTime");
            if (dateTimeObj instanceof java.sql.Timestamp ts) {
                dateTime = ts.toLocalDateTime();
            } else if (dateTimeObj instanceof LocalDateTime ldt) {
                dateTime = ldt;
            }

            String account = row.get("account", String.class);
            String commandLine = row.get("commandLine", String.class);

            // Defensive cast in case DB returns Short, Integer, etc.
            Number retryCountNum = row.get("retryCount", Number.class);
            Integer retryCount = retryCountNum != null ? retryCountNum.intValue() : null;

            FailedTransSummaryDTO dto = new FailedTransSummaryDTO(
                    caseNumber, piId, dateTime, account, commandLine, retryCount, extractNonMon(commandLine)
            );
            result.add(dto);
        }

        return result;
    }

    public static String extractNonMon(String commandLine) {
        int iPosition;
        int iNext;
        String sNonMon = "";

        // Check if "CNONMON'" exists in the command line
        if (commandLine.contains("CNONMON'")) {
            iPosition = commandLine.indexOf("CNONMON'");

            // Move iPosition 12 characters ahead (to get past "CNONMON'")
            iPosition = iPosition + 12;

            // Find the position of the next "',"
            iNext = commandLine.indexOf("','", iPosition);

            // Ensure iNext is valid
            if (iNext > iPosition) {
                // Move iNext to the start of the non-monetary value
                iNext = iNext + 3; // past "',"

                // Extract 2 characters starting at this position
                if (iNext + 2 <= commandLine.length()) {
                    sNonMon = commandLine.substring(iNext, iNext + 2);

                    // Check if the last character of sNonMon is a "'" and remove it if so
                    if (sNonMon.endsWith("'")) {
                        sNonMon = sNonMon.substring(0, 1);
                    }
                }
            }
        }

        return sNonMon;
    }
}
