package bartelloni.guglielmo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.Contact;
import lombok.extern.java.Log;

/**
 * ContactsProcessor
 */
@Component
@Log
public class ContactsListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void process(Contact contact){
        log.info("listened: " + contact);
    }


    
}
