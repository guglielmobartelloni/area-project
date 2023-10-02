package bartelloni.guglielmo;

import bartelloni.guglielmo.repository.elastic.ContactDocumentRepository;
import bartelloni.guglielmo.service.ContactDocumentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class ContactsManagerProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerProcessorApplication.class, args);
    }

     @Bean
     CommandLineRunner commandLineRunnerTest(ContactDocumentService service, ContactDocumentRepository repo) {
         return args -> {
            for (var contact : service.getAll()){
                repo.delete(contact);
                log.info("Deleted contact: " +contact);
            }
         };

     }
}
