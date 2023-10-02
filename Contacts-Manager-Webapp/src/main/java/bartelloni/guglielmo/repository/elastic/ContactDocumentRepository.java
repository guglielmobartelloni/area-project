package bartelloni.guglielmo.repository.elastic;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import bartelloni.guglielmo.model.ContactDocument;

/**
 * ContactDocumentRepository
 */
@Repository
public interface ContactDocumentRepository extends ElasticsearchRepository<ContactDocument, Long> {
    @Query("{\"query\":{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"?0\",\"fields\":[\"name\",\"surname\",\"address\",\"other_info\"]}},{\"term\":{\"phone.keyword\":\"1234567890\"}}]}}}")
    List<ContactDocument> searchContacts(String search);


    List<ContactDocument> findBySurnameOrNameOrAddressOrOtherInfoOrPhoneOrLatOrLon(String surname, String name, String address, String otherInfo, String phone, String lat, String lon);


}
