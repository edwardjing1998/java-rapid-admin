package admin.service;

import org.springframework.stereotype.Service;
import admin.dto.CaseDTO;
import admin.repository.CaseRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CaseService {

    private final CaseRepository caseRepository;

    // ✅ Constructor injection
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public Map<String, List<CaseDTO>> getCasesByDisposition(List<String> dispositions) {
        List<Object[]> raw = caseRepository.fetchCasesByDisposition(dispositions);
        return raw.stream()
                .collect(Collectors.groupingBy(
                        row -> (String) row[0],
                        Collectors.mapping(row -> mapToCaseDTO(row), Collectors.toList())
                ));
    }

    private CaseDTO mapToCaseDTO(Object[] row) {
        return CaseDTO.builder()
                .client((String) row[0])
                .caseNumber((String) row[1])
                .account((String) row[2])
                .lastName((String) row[3])
                .firstName((String) row[4])
                .addr1((String) row[5])
                .addr2((String) row[6])
                .city((String) row[7])
                .state((String) row[8])
                .zip((String) row[9])
                .homePhone((String) row[10])
                .workPhone((String) row[11])
                .status((String) row[12])
                .numCards(row[13] != null ? ((Number) row[13]).intValue() : null)
                .nextDate(row[14] != null ? ((Date) row[14]).toLocalDate() : null)
                .noRenewal((Boolean) row[15])
                .reason((String) row[16])
                .disposition((String) row[17])
                .inDate(row[18] != null ? ((Date) row[18]).toLocalDate() : null)
                .deliveryId((String) row[19])
                .sysPrin((String) row[20])
                .outDate(row[21] != null ? ((Date) row[21]).toLocalDate() : null)
                .cycle((String) row[22])
                .active((Boolean) row[23])
                .inHour(row[24] != null ? ((Time) row[24]).toLocalTime() : null)
                .autoDate(row[25] != null ? ((Date) row[25]).toLocalDate() : null)
                .subreason((String) row[26])
                .build();
    }
}
