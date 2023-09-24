package bartelloni.guglielmo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.service.ContactDocumentService;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class ContactsManagerProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerProcessorApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitTemplate template) {
        return args -> {
            Contact contact = Contact.builder().name("Nome").surname("Cognome").phone("3248989883").lat("-16.95832")
                    .lon("-64.06230").otherInfo("Altre info").address("via della madonna 13").build();
            template.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, contact);
            log.info("FATTO");
        };

    }

    @Bean
    CommandLineRunner commandLineRunnerTest(ContactDocumentService service) {
        return args -> {
            service.getAll().forEach(e -> log.info("Contact: " + e));
        };

    }
}
