package bartelloni.guglielmo.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bartelloni.guglielmo.model.Contact;

/**
 * ContactDocumentRepository
 */
@Repository
public interface ContactDocumentRepository extends ElasticsearchRepository<Contact, Long>{
}
