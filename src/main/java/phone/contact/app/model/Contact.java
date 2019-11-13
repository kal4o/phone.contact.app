package phone.contact.app.model;

import org.hibernate.usertype.UserType;

public class Contact {

    private Integer id;

    private String firstName;

    private String lastName;

    public UserType contactType;

    private String contactNumber;

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

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactType(UserType contactType) {
        this.contactType = contactType;
    }
}
