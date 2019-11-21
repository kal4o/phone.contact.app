package phone.contact.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import phone.contact.app.model.PhoneNumber;
import phone.contact.app.service.PhoneNumberService;

@RestController
@RequestMapping("api/phonenumber")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @PostMapping
    public void createOrUpdatePhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        phoneNumberService.createOrUpdatePhoneNumber(phoneNumber);
    }

    @GetMapping("/{phoneNumberId}")
    public PhoneNumber getContact(@PathVariable("phoneNumberId") Integer phoneNumberId) {
        return phoneNumberService.getPhoneNumber(phoneNumberId);
    }

    @DeleteMapping("/{phoneNumberId}")
    public void deletePhoneNumber(@PathVariable("phoneNumberId") Integer phoneNumberId) {
        phoneNumberService.deletePhoneNumber(phoneNumberId);
    }

}
