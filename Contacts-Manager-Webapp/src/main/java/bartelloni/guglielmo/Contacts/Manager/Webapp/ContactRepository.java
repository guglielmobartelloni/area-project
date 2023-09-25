package bartelloni.guglielmo.Contacts.Manager.Webapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ContactRepository
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>{
    
}
