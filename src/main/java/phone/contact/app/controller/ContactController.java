package phone.contact.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phone.contact.app.model.Contact;
import phone.contact.app.service.ContactService;

@RestController
@RequestMapping("api/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public void createOrUpdateContact(@RequestBody Contact contact) {
        contactService.createOrUpdateContact(contact);
    }

    @GetMapping("/{contactId}")
    public Contact getContact(@PathVariable("contactId") Integer contactId) {
        return contactService.getContact(contactId);
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable("contactId") Integer contactId) {
        contactService.deleteContact(contactId);
    }
}

