package bartelloni.guglielmo.controller;

import java.util.Objects;
import java.util.Optional;

import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.service.ContactService;
import bartelloni.guglielmo.service.RabbitPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.github.wimdeblauwe.hsbt.mvc.HxRefresh;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import lombok.extern.java.Log;

/**
 * MainController
 */
@Controller
@Log
public class ContactController {

    @Autowired
    private ContactService service;

    @Autowired
    private RabbitPublisher rabbitPublisher;

    @GetMapping("/new")
    public String newContact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Optional<Contact> optionalContact = service.getById(id);
        var contact = optionalContact.orElseThrow();
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/contact")
    public String processContact(Model model, @ModelAttribute Contact contact) {
        boolean isNew = contact.getId() == null;
        service.upsert(contact);
        if (isNew) {
            rabbitPublisher.newContact(contact);
        } else {
            rabbitPublisher.editContact(contact);
        }
        model.addAttribute("contacts", service.getAll());
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    @HxRequest
    @HxRefresh
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        var contact = service.getById(id).orElseThrow();
        service.delete(contact);
        rabbitPublisher.deleteContact(contact);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
