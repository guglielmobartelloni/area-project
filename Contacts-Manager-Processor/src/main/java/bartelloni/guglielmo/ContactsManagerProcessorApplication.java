package bartelloni.guglielmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class ContactsManagerProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerProcessorApplication.class, args);
    }

}
