package phone.contact.app.model;

import org.hibernate.annotations.Where;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contacts")
@Where(clause = "is_deleted = false")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    public Integer id;

    @Column(name = "first_name")
    @NotEmpty
    public String firstName;

    @Column(name = "last_name")
    @NotEmpty
    public String lastName;

    @Column(name = "type")
    @NotNull
    public UserType contactType;

    @Column(name = "contact_number")
    public String contactNumber;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;

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

    public UserType getContactType() {
        return contactType;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactType(UserType contactType) {
        this.contactType = contactType;
}

