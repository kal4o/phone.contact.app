package phone.contact.app.model;

import org.hibernate.annotations.Where;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contacts")
@Where(clause = "is_deleted = false")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;

    @Column(name = "first_name")
    @NotEmpty
    public String firstName;

    @Column(name = "last_name")
    @NotEmpty
    public String lastName;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;

    @OneToMany(mappedBy = "contactId", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<PhoneNumber> myPhoneNumbers = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PhoneNumber> getMyPhoneNumbers() {
        return myPhoneNumbers;
    }

    public void setMyPhoneNumbers(List<PhoneNumber> myPhoneNumbers) {
        this.myPhoneNumbers = myPhoneNumbers;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

