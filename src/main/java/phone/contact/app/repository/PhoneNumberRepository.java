package phone.contact.app.repository;

import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phone.contact.app.model.PhoneNumber;
import phone.contact.app.model.enums.ContactType;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Integer> {

    @Query("SELECT p FROM PhoneNumber p WHERE phoneNumber=:phoneNumber")
    public List<PhoneNumber> findByNumber(@Param("phoneNumber")PhoneNumber phoneNumber);

    @Query("SELECT p FROM PhoneNumber p WHERE contactType=:contactType")
    public List<PhoneNumber> findByType(@Param("contactType")ContactType contactType);

    @Query("UPDATE PhoneNumber SET isDeleted = true WHERE id = :id")
    @Modifying
    public void deactivatePhoneNumber(@Param("id") Integer id);
}

