package phone.contact.app.repository;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phone.contact.app.model.PhoneNumber;
import phone.contact.app.model.enums.ContactType;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

    @Query("SELECT p FROM numbers p WHERE p.phone_number=:phoneNumber")
    public List<PhoneNumber> findByNumber(@Param("phoneNumber")PhoneNumber phoneNumber);

    @Query("SELECT p FROM numbers p WHERE p.contact_type=:contactType")
    public List<PhoneNumber> findByType(@Param("contactType")ContactType contactType);

    @Query("UPDATE PhoneNumber SET isDeleted = true WHERE id = :id")
    public void deactivatePhoneNumber(@Param("id") Integer id);
}

