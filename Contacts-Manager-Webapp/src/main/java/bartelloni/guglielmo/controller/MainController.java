package bartelloni.guglielmo.controller;

import bartelloni.guglielmo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MainController
 */
@Controller
public class MainController {

    @Autowired
    private ContactService service;

    @GetMapping
    public String index(Model model){
        var contacts = service.getAll();
        model.addAttribute("contacts", contacts);
        return "index";
    }

}
