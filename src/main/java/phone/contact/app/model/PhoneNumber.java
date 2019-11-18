package phone.contact.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "numbers")
public class PhoneNumber {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "number_type")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(name = "contact_id")
    @NotEmpty
    public Integer contactId;

    @Column(name = "phone_number")
    @NotEmpty
    public String phoneNumber;


}
