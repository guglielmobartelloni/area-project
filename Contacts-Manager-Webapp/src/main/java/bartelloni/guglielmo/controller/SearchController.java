package bartelloni.guglielmo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bartelloni.guglielmo.model.ContactDocument;
import bartelloni.guglielmo.repository.elastic.ContactDocumentRepository;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import lombok.extern.java.Log;

/**
 * SearchController
 */
@Controller
@RequestMapping("/search")
@Log
public class SearchController {

    @Autowired
    private ContactDocumentRepository repo;

    @GetMapping
    public String search(Model model, @RequestParam String search) throws ElasticsearchException, IOException {
        log.info("Searched: " + search);

        List<ContactDocument> searchContacts = repo.findBySurnameOrNameOrAddressOrOtherInfoOrPhoneOrLatOrLon(search,
                search, search, search, search, search, search);

        for (var element : searchContacts) {
            log.info("Found contact: " + element);
        }

        model.addAttribute("contacts", searchContacts);
        return "index :: contacts-table";
    }

    // private List<Contact> getResult(String search){
    // Criteria criteria = new Criteria().fuzzy(search);
    // Query query = new CriteriaQuery(criteria);
    // SearchHits<ContactDocument> contactDocumentHits = elasticsearchClient
    // .search(query, ContactDocument.class);
    //
    // contactDocumentHits.get().forEach(e-> log.info("" + e.getId()+" score for
    // contact: " + e.getContent()));
    //
    // return contactDocumentHits.stream().map(e -> {
    // var contactDocument = e.getContent();
    //
    // return
    // Contact.builder().name(contactDocument.getName()).surname(contactDocument.getSurname())
    // .id(contactDocument.getIdContact()).otherInfo(contactDocument.getOtherInfo())
    // .lat(contactDocument.getLat()).lon(contactDocument.getLon()).phone(contactDocument.getPhone())
    // .build();
    // }).limit(10).toList();
    // }

}
