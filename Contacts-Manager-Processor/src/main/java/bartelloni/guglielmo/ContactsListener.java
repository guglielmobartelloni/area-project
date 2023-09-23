package bartelloni.guglielmo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.service.ContactService;
import lombok.extern.java.Log;

/**
 * ContactsProcessor
 */
@Component
@Log
public class ContactsListener {

    @Autowired
    private ContactService contactService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void process(Contact contact){
        var contactResult = contactService.upsert(contact);
        log.info("Upserted contact contact: " + contactResult);
    }


    
}
