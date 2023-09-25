package bartelloni.guglielmo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RabbitContact
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RabbitContact extends Contact {

    private Operation operation;

    public RabbitContact(Contact contact, Operation operation) {
        super(contact.getId(), contact.getIdContact(), contact.getName(), contact.getSurname(), contact.getPhone(),
                contact.getAddress(),
                contact.getLat(), contact.getLon(), contact.getOtherInfo());
        this.operation = operation;
    }
}
