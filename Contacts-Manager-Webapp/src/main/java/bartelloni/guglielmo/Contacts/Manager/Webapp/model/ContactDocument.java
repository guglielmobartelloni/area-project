package bartelloni.guglielmo.Contacts.Manager.Webapp.model;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "contacts")
public class ContactDocument {

    @Id
    private String id;

    private Long contactId;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String lat;
    private String lon;
    private String otherInfo;

}
