package bartelloni.guglielmo.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import bartelloni.guglielmo.model.ContactDocument;

/**
 * ContactDocumentRepository
 */
public interface ContactDocumentRepository extends ElasticsearchRepository<ContactDocument, Long>{
}
