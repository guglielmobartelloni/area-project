package bartelloni.guglielmo.Contacts.Manager.Webapp.model;

import bartelloni.guglielmo.Contacts.Manager.Webapp.Contact;
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

public enum Operation {
    NEW,
    EDIT,
    DELETE
}
