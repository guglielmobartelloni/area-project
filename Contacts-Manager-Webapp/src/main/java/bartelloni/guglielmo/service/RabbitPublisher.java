package bartelloni.guglielmo.service;

import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.configuration.MQConfig;
import bartelloni.guglielmo.model.Operation;
import bartelloni.guglielmo.model.RabbitContact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

/**
 * RabbitService
 */
@Service
@Log
public class RabbitPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void newContact(Contact contact) {
        RabbitContact rabbitContact = new RabbitContact(contact, Operation.NEW);
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, rabbitContact);

        log.info("New contact event: " + rabbitContact);
    }

    public void editContact(Contact contact) {
        RabbitContact rabbitContact = new RabbitContact(contact, Operation.EDIT);
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, rabbitContact);
        log.info("Edit contact event: " + rabbitContact);
    }

    public void deleteContact(Contact contact) {
        RabbitContact rabbitContact = new RabbitContact(contact, Operation.DELETE);
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE, MQConfig.ROUTING_KEY, rabbitContact);
        log.info("Delete contact event: " + rabbitContact);
    }

}
