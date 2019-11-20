package phone.contact.app.model;

import phone.contact.app.model.enums.ContactType;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "numbers")
public class PhoneNumber {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "contact_type")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contact_id")
    public Contact contactId;

    @Column(name = "phone_number")
    @NotEmpty
    public String phoneNumber;

    @Column(name = "isDeleted")
    private boolean isDeleted = false;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}