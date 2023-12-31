
package bartelloni.guglielmo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Contact
 */
@Data
@RequiredArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class Contact {

    private Long id;

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String lat;
    private String lon;

    private String otherInfo;

}
