package bartelloni.guglielmo.model;

import org.springframework.data.elasticsearch.annotations.Document;

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

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String lat;
    private String lon;
    private String otherInfo;

}
