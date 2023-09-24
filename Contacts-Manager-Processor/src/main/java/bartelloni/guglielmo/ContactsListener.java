package bartelloni.guglielmo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.ContactDocument;
import bartelloni.guglielmo.service.ContactDocumentService;
import lombok.extern.java.Log;

/**
 * ContactsProcessor
 */
@Component
@Log
public class ContactsListener {

    @Autowired
    private ContactDocumentService contactService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void process(ContactDocument contact){
        var contactResult = contactService.upsert(contact);
        log.info("Upserted contact contact: " + contactResult);
    }

    
}
