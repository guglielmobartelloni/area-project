package bartelloni.guglielmo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import bartelloni.guglielmo.model.Contact;

/**
 * ContactRepository
 */
public interface ContactRepository extends JpaRepository<Contact, Long>{

    
}
