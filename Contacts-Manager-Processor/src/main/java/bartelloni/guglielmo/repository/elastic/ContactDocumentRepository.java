package bartelloni.guglielmo.repository.elastic;

import bartelloni.guglielmo.model.ContactDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bartelloni.guglielmo.model.Contact;

import java.util.Optional;

/**
 * ContactDocumentRepository
 */
@Repository
public interface ContactDocumentRepository extends ElasticsearchRepository<ContactDocument, Long>{
    void deleteByIdContact(Long idContact);
    Optional<ContactDocument> getByIdContact(Long idContact);
}
