package bartelloni.guglielmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bartelloni.guglielmo.repository.elastic.ContactDocumentRepository;
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
    public String search(Model model, @RequestParam String search){
        log.info("Searched: "+search);

        log.info("" + repo.findAll());
        model.addAttribute("contacts", null);
        return "index :: contacts-table";

    }

    
}
