package bartelloni.guglielmo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.repository.jpa.ContactRepository;

/**
 * ContactService
 */
@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact upsert(Contact contact){
        return repository.save(contact);
    }


    public Iterable<Contact> getAll(){
        return repository.findAll();
    }

    public Optional<Contact> getById(Long id){
        return repository.findById(id);
    }

    public void delete(Contact contact){
        repository.delete(contact);
    }
    
}
