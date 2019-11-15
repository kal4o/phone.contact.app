package phone.contact.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contact.app.model.Contact;
import phone.contact.app.model.repository.ContactRepository;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact getContact(Integer contactId) {
        return null;
    }

    public void createOrUpdateContact(Contact contact) {
        if(null==contact.getId()) {
            createContact(contact);
         return;
        }
        updateContact(contact);
    }

    public Contact getContact(Integer contactId) {

    }





}
