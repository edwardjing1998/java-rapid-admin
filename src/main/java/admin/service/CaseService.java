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
        return new CaseDTO.Builder()
                .client((String) row[0])
                .caseNumber((String) row[1])
                .account((String) row[2])
                .lastName((String) row[3])
                .firstName((String) row[4])
                .hmPhone((String) row[5])
                .wkPhone((String) row[6])
                .status((Character) row[7])
                .numCards(row[8] != null ? ((Number) row[8]).intValue() : null)
                .nextDate(row[9] != null ? ((Date) row[9]).toLocalDate() : null)
                .reason((Character) row[10])
                .disposition((Character) row[11])
                .inDate(row[12] != null ? ((Date) row[12]).toLocalDate() : null)
                .deliveryId(row[13] != null ? ((Number) row[13]).intValue() : null)
                .sysPrin((String) row[14])
                .outDate(row[15] != null ? ((Date) row[15]).toLocalDate() : null)
                .cycle((Character) row[16])
                .active(row[17] != null ? (Boolean) row[17] : false)
                .inHour(row[18] != null ? ((Number) row[18]).intValue() : null)
                .autoDate(row[19] != null ? ((Date) row[19]).toLocalDate() : null)
                .subreason(row[20] != null ? ((Number) row[20]).intValue() : null)
                .build();
    }

}
