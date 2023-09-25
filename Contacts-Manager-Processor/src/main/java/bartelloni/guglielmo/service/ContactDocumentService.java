package bartelloni.guglielmo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bartelloni.guglielmo.model.ContactDocument;
import bartelloni.guglielmo.repository.elastic.ContactDocumentRepository;

/**
 * ContactService
 */
@Service
public class ContactDocumentService {

    @Autowired
    private ContactDocumentRepository repository;

    public ContactDocument upsert(ContactDocument contact){
        return repository.save(contact);
    }


    public List<ContactDocument> getAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<ContactDocument> getById(Long id){
        return repository.findById(id);
    }

    public void delete(ContactDocument contact){
        repository.delete(contact);
    }
    
}
