package com.springbootworkshop.addressbookproject.services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.model.Contact;
import com.springbootworkshop.addressbookproject.exceptions.ContactException;
import com.springbootworkshop.addressbookproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//@Repository
@Service
public class ContactService implements IContactService
{
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContactData() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getAllContactData()
    {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(UUID contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactException("Contact With contactID " +
                        contactId +"does not exists"));
    }

    @Override
    public Contact addContactData(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        contact.setCreatedTimeStamp(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContactData(UUID contactId, ContactDTO contactDTO) {
        Contact contact = this.getContactById(contactId);
        contact.setFirstName(contactDTO.firstName);
        contact.setLastName(contactDTO.lastName);
        contact.setGender(contactDTO.gender);
        contact.setMobileNumber(contactDTO.mobileNumber);
        contact.setEmailID(contactDTO.emailID);
        contact.setUpdatedTimeStamp(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContactData(UUID contactId) {
        Contact contact = this.getContactById(contactId);
        contactRepository.delete(contact);
    }
}
