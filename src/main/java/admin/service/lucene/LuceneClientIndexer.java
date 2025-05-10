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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LuceneClientIndexer {

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
        System.out.println("Lucene indexing completed. Total indexed: " + clients.size());
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
            TopDocs topDocs = searcher.search(query, 100);

            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                String client = doc.get("client");
                String name = doc.get("name");

                // Create a unique signature for deduplication
                String key = client + "::" + name;

                if (seen.add(key)) { // only add if not seen
                    results.add(new ClientSearchDTO(client, name));
                }
            }
        }

        return results;
    }

}
