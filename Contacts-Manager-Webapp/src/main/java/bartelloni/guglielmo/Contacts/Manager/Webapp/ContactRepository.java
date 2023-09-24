package bartelloni.guglielmo.Contacts.Manager.Webapp;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ContactRepository
 */
public interface ContactRepository extends JpaRepository<Contact,Long>{
    
}
