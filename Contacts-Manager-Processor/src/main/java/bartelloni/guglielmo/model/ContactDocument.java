
package bartelloni.guglielmo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Contact
 */
@Data
@RequiredArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@Document(indexName = "contacts")
public class ContactDocument {

    @Id
    private String id;


    private Long idContact;

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String lat;
    private String lon;

    private String otherInfo;

}
