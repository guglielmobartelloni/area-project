package bartelloni.guglielmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import lombok.extern.java.Log;

@SpringBootApplication
@Log
@EnableElasticsearchRepositories(basePackages = "bartelloni.guglielmo.repository.elastic")
@EnableJpaRepositories(basePackages = "bartelloni.guglielmo.repository.jpa")
public class ContactsManagerWebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerWebappApplication.class, args);
    }

}
