package bartelloni.guglielmo.Contacts.Manager.Webapp;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactsManagerWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerWebappApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContactService contactService) {
        return args -> {

            EasyRandom generator = new EasyRandom();
            List<Contact> contacts = generator.objects(Contact.class, 20)
                    .collect(Collectors.toList());

            for (Contact contact : contacts) {
                contactService.upsert(contact);
            }
            // Contact contact =
            // Contact.builder().name("Nome").surname("Cognome").phone("3248989883").lat("-16.95832")
            // .lon("-64.06230").otherInfo("Altre info").address("via della madonna
            // 13").build();
        };
    }

}
