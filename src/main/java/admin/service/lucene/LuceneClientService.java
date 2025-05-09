package admin.service.lucene;
import admin.dto.ClientSearchDTO;
import admin.model.Client;
import admin.repository.ClientRepository;
import admin.service.lucene.LuceneClientIndexer;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LuceneClientService {
    private final ClientRepository clientRepository;
    private final LuceneClientIndexer luceneIndexer;

    public LuceneClientService(ClientRepository clientRepository, LuceneClientIndexer luceneIndexer) {
        this.clientRepository = clientRepository;
        this.luceneIndexer = luceneIndexer;
    }

    @PostConstruct
    public void initLucene() throws Exception {
        luceneIndexer.indexClients(clientRepository.findForSearch());
    }

    public List<ClientSearchDTO> getClientSearch(String keyword) throws Exception {
        return luceneIndexer.searchClients(keyword).stream()
                .map(c -> new ClientSearchDTO(c.getClient(), c.getName()))
                .collect(Collectors.toList());
    }
}
