package phone.contact.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contact.app.model.PhoneNumber;
import phone.contact.app.model.repository.PhoneNumberRepository;

import java.util.Optional;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }


    public void createOrUpdatePhoneNumber(PhoneNumber phoneNumber) {
        if(null==phoneNumber.getId()) {
            createPhoneNumber(phoneNumber);
            return;
        }
        updatePhoneNumber(phoneNumber);
    }


    public PhoneNumber getPhoneNumber(Integer phoneNumberId) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        if(phoneNumber.isPresent()) {
            throw new RuntimeException("PhoneNumber not found!");
        }

        return phoneNumber.get();
    }

    private void updatePhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }

    private void createPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }


    public void deletePhoneNumber(Integer phoneNumberId) {
        phoneNumberRepository.deactivatePhoneNumber(phoneNumberId);
    }

}

