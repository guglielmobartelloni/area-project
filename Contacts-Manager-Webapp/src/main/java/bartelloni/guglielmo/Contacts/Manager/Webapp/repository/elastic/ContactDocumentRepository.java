package bartelloni.guglielmo.Contacts.Manager.Webapp.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bartelloni.guglielmo.Contacts.Manager.Webapp.model.ContactDocument;


/**
 * ContactDocumentRepository
 */
@Repository
public interface ContactDocumentRepository extends ElasticsearchRepository<ContactDocument, Long>{
}
