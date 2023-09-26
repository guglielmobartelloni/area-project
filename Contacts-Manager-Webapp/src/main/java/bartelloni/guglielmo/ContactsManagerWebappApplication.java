package bartelloni.guglielmo;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.service.ContactService;
import bartelloni.guglielmo.service.RabbitPublisher;
import lombok.extern.java.Log;

@SpringBootApplication
@Log
@EnableElasticsearchRepositories(basePackages = "bartelloni.guglielmo.repository.elastic")
@EnableJpaRepositories(basePackages = "bartelloni.guglielmo.repository.jpa")
public class ContactsManagerWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerWebappApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContactService contactService, RabbitPublisher publisher) {
        return args -> {

            EasyRandom generator = new EasyRandom();
            List<Contact> contacts = generator.objects(Contact.class, 20)
                    .collect(Collectors.toList());

            for (Contact contact : contacts) {
                contactService.upsert(contact);
                publisher.newContact(contact);
            }
            // Contact contact =
            // Contact.builder().name("Nome").surname("Cognome").phone("3248989883").lat("-16.95832")
            // .lon("-64.06230").otherInfo("Altre info").address("via della madonna
            // 13").build();
        };
    }

}
