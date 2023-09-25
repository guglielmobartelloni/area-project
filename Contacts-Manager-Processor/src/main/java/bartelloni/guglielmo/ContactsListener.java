package bartelloni.guglielmo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.RabbitContact;
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
    public void process(RabbitContact contact) {
        switch (contact.getOperation()) {
            case NEW -> contactService.upsert(contact);
            case EDIT -> contactService.upsert(contact);
            case DELETE -> contactService.delete(contact);
        }
        log.info("Processed contact: " + contact);
    }

}
