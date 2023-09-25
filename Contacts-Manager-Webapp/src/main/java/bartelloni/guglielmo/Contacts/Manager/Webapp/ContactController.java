package bartelloni.guglielmo.Contacts.Manager.Webapp;

import java.util.Optional;

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

    @GetMapping("/new")
    public String newContact(Model model){
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model){
        Optional<Contact> optionalContact = service.getById(id);
        var contact = optionalContact.orElseThrow();
        model.addAttribute("contact", contact);
        return "contact-form";
    }

    @PostMapping("/contact")
    public String processContact(Model model, @ModelAttribute Contact contact){
        log.info("Contact: " + contact);
        service.upsert(contact);
        model.addAttribute("contacts", service.getAll());
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    @HxRequest
    @HxRefresh
    public ResponseEntity<String> deleteContact(@PathVariable Long id){
        var contact = service.getById(id).orElseThrow();
        service.delete(contact);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
