package phone.contact.app.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phone.contact.app.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
