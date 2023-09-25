package bartelloni.guglielmo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * RabbitContact
 */
@Getter
@Setter
public class RabbitContact extends Contact {

    private Operation operation;

    public RabbitContact(Contact contact, Operation operation) {
        super(contact.getId(), contact.getName(), contact.getSurname(), contact.getPhone(), contact.getAddress(),
                contact.getLat(), contact.getLon(), contact.getOtherInfo());
        this.operation = operation;
    }
}

