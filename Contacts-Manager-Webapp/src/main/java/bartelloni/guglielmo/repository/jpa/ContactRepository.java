package bartelloni.guglielmo.repository.jpa;

import bartelloni.guglielmo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContactRepository
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>{
    
}
