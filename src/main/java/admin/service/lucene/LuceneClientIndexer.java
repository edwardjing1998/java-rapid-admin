package admin.service.lucene;

import admin.dto.ClientSearchDTO;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LuceneClientIndexer {
    private static final Logger logger = LoggerFactory.getLogger(LuceneClientIndexer.class);
    private final Directory memoryIndex = new RAMDirectory();
    private final StandardAnalyzer analyzer = new StandardAnalyzer();
    private boolean indexInitialized = false; // 👈 flag to ensure search only works after indexing

    public void indexClients(List<ClientSearchDTO> clients) throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        try (IndexWriter writer = new IndexWriter(memoryIndex, config)) {
            writer.deleteAll(); // Clean previous data
            for (ClientSearchDTO client : clients) {
                Document doc = new Document();

                // Use TextField for both fields for full-text search
                doc.add(new TextField("client", client.getClient(), Field.Store.YES));
                doc.add(new TextField("name", client.getName(), Field.Store.YES));

                writer.addDocument(doc);
            }
            writer.commit(); // ✅ Ensure all documents are committed
        }
        indexInitialized = true;
        logger.info("Lucene indexing completed. Total indexed: {}" , clients.size());
    }

    public List<ClientSearchDTO> searchClients(String keyword) throws Exception {
        if (!indexInitialized) {
            throw new IllegalStateException("Lucene index is not initialized yet.");
        }

        List<ClientSearchDTO> results = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        String escapedKeyword = MultiFieldQueryParser.escape(keyword);
        Query query = new MultiFieldQueryParser(
                new String[]{"client", "name"}, analyzer
        ).parse(escapedKeyword + "*");

        try (DirectoryReader reader = DirectoryReader.open(memoryIndex)) {
            IndexSearcher searcher = new IndexSearcher(reader);

            TotalHitCountCollector countCollector = new TotalHitCountCollector();
            searcher.search(query, countCollector);
            int totalHits = countCollector.getTotalHits();

            if (totalHits == 0) {
                return results; // 👈 return empty list
            }

            TopDocs topDocs = searcher.search(query, totalHits);

            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                String client = doc.get("client");
                String name = doc.get("name");

                String key = client + "::" + name;

                if (seen.add(key)) {
                    results.add(new ClientSearchDTO(client, name));
                }
            }
        }

        return results;
    }
}