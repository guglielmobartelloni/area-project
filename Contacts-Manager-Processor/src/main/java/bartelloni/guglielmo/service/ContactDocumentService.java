package bartelloni.guglielmo.service;

import java.util.Optional;

import bartelloni.guglielmo.model.ContactDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.repository.elastic.ContactDocumentRepository;
import lombok.extern.java.Log;

/**
 * ContactService
 */
@Service
@Log
public class ContactDocumentService {

    @Autowired
    private ContactDocumentRepository repository;

    public ContactDocument newContact(Contact contact){
        var contactDocument = convertContact(contact);
        log.info("Contact document: " + contactDocument);
        return repository.save(contactDocument);
    }

    public ContactDocument editContact(Contact contact){
        var contactDocument = repository.getByIdContact(contact.getId()).orElseThrow();
        contactDocument.setAddress(contact.getAddress());
        contactDocument.setLat(contact.getLat());
        contactDocument.setLon(contact.getLon());
        contactDocument.setName(contact.getName());
        contactDocument.setOtherInfo(contact.getOtherInfo());
        contactDocument.setPhone(contact.getPhone());
        contactDocument.setSurname(contact.getSurname());
        return repository.save(contactDocument);
    }

    public Iterable<ContactDocument> getAll(){
        return repository.findAll();
    }

    public Optional<ContactDocument> getById(Long id){
        return repository.findById(id);
    }

    public void delete(Contact contact){
        repository.deleteByIdContact(contact.getId());
    }

    private ContactDocument convertContact(Contact contact){
        return ContactDocument.builder()
                .idContact(contact.getId())
                .address(contact.getAddress())
                .lat(contact.getLat())
                .lon(contact.getLon())
                .name(contact.getName())
                .otherInfo(contact.getOtherInfo())
                .phone(contact.getPhone())
                .surname(contact.getSurname()).build();
    }
    
}

