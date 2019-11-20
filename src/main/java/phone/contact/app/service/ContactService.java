package phone.contact.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contact.app.model.Contact;

import phone.contact.app.repository.ContactRepository;

import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }



    public void createOrUpdateContact(Contact contact) {
        if(null==contact.getId()) {
            createContact(contact);
         return;
        }
        updateContact(contact);
    }


    public Contact getContact(Integer contactId) {
        Optional<Contact> contact = contactRepository.findById(contactId);
        if(contact.isPresent()) {
            throw new RuntimeException("Contact not found!");
        }

        return contact.get();
    }

    private void updateContact(Contact contact) {
        contactRepository.save(contact);
    }

    private void createContact(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteContact(Integer contactId) {
        // customerRepository.deleteById(customerId);  //nikoga ne triem!!
        contactRepository.deactivateContact(contactId);
    }

}
