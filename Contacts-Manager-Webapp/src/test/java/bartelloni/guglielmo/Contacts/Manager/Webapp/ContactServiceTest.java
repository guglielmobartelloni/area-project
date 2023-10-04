package bartelloni.guglielmo.Contacts.Manager.Webapp;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import bartelloni.guglielmo.model.Contact;
import bartelloni.guglielmo.repository.jpa.ContactRepository;
import bartelloni.guglielmo.service.ContactService;
import org.springframework.data.domain.Sort;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;
/**
 * ContactServiceTest
 */
@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    private Contact contact;

    @BeforeEach
    public void setup() {
        contact = Contact.builder()
                .id(1L)
                .name("Ramesh")
                .surname("Fadatare")
                .phone("3245676665")
                .otherInfo("Queste sono altre info")
                .address("Via dei mille")
                .lat("45.456")
                .lon("12.345")
                .build();
    }

    @DisplayName("JUnit test for upsert contact method")
    @Test
    public void testInsertContact(){
        given(contactRepository.save(contact)).willReturn(contact);
        System.out.println(contactRepository);
        System.out.println(contactService);

        Contact savedContact = contactService.upsert(contact);

        System.out.println(savedContact);
        assertThat(savedContact).isNotNull();
    }


    // JUnit test for getAllEmployees method
    @DisplayName("JUnit test for getAll method")
    @Test
    public void testGetAllContacts(){
        // given - precondition or setup

        Contact contact1 = Contact.builder()
                .id(2L)
                .name("Tony")
                .surname("Stark")
                .phone("3245676665")
                .address("Via dei mille")
                .otherInfo("Queste sono altre info")
                .lat("45.456").lon("12.345")
                .build();

        given(contactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))).willReturn(List.of(contact,contact1));

        // when -  action or the behaviour that we are going test
        Iterable<Contact> contacts = contactService.getAll();

        // then - verify the output
        assertThat(contacts).isNotNull();
        assertThat(contacts).containsExactly(contact,contact1);
    }

}
