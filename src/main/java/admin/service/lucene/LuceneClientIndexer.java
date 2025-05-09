package admin.service.lucene;

import admin.dto.ClientSearchDTO;
import admin.model.Client;
import admin.model.ClientLucene;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LuceneClientIndexer {

    private final Directory memoryIndex = new RAMDirectory();
    private final StandardAnalyzer analyzer = new StandardAnalyzer();

    public void indexClients(List<ClientSearchDTO> clients) throws Exception {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        try (IndexWriter writer = new IndexWriter(memoryIndex, config)) {
            writer.deleteAll();
            for (ClientSearchDTO client : clients) {
                Document doc = new Document();
                doc.add(new StringField("client", client.getClient(), Field.Store.YES));
                doc.add(new TextField("name", client.getName(), Field.Store.YES));
                writer.addDocument(doc);
            }
        }
    }

    public List<ClientSearchDTO> searchClients(String keyword) throws Exception {

        List<ClientSearchDTO> results = new ArrayList<>();

        Query query = new org.apache.lucene.queryparser.classic.MultiFieldQueryParser(
                new String[]{"client", "name"},
                analyzer
        ).parse(keyword + "*");

        try (DirectoryReader reader = DirectoryReader.open(memoryIndex)) {
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs topDocs = searcher.search(query, 10);

            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document doc = searcher.doc(scoreDoc.doc);
                results.add(new ClientSearchDTO(doc.get("client"), doc.get("name")));
            }
        }
        return results;
    }
}
