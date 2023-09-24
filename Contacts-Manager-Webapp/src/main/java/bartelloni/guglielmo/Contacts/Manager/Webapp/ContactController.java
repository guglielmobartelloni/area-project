package bartelloni.guglielmo.Contacts.Manager.Webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MainController
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @GetMapping("/new")
    public String newContact(Model model){
        var contacts = service.getAll();
        model.addAttribute("contacts", contacts);
        return "contact-form";
    }

}
