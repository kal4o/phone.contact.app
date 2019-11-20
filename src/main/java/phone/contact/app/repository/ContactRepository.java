package phone.contact.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phone.contact.app.model.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    @Query("SELECT c FROM Contact c WHERE firstName = :firstName")
    public List<Contact> findByFirstName(@Param("firstName")Contact firstName);

    @Query("Update Contact SET isDeleted = true WHERE id = :id")
    public void deactivateContact(@Param("id") Integer id);

}
