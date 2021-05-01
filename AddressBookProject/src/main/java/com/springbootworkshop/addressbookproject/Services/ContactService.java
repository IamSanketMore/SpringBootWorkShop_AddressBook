package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import com.springbootworkshop.addressbookproject.exceptions.ContactException;
import com.springbootworkshop.addressbookproject.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Repository
@Service
public class ContactService implements IContactService
{
    @Autowired
    private ContactRepository contactRepository;

    List<ContactData> contactDataList = new ArrayList<ContactData>();
    @Override
    public List<ContactData> getContactData() {
        return contactRepository.findAll();
    }

    @Override
    public List<ContactData> getAllContactData()
    {
        return contactRepository.findAll();
    }

    @Override
    public ContactData getContactById(UUID contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ContactException("Contact With contactID " +
                        contactId +"does not exists"));
    }

    @Override
    public ContactData addContactData(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(contactDTO);
        contactData.setCreatedTimeStamp(LocalDateTime.now());

        return contactRepository.save(contactData);
    }

    @Override
    public ContactData updateContactData(UUID contactId, ContactDTO contactDTO) {
        ContactData contactData = this.getContactById(contactId);
        contactData.setFirstName(contactDTO.firstName);
        contactData.setLastName(contactDTO.lastName);
        contactData.setGender(contactDTO.gender);
        contactData.setMobileNumber(contactDTO.mobileNumber);
        contactData.setEmailID(contactDTO.emailID);
        contactData.setUpdatedTimeStamp(LocalDateTime.now());
        return contactRepository.save(contactData);
    }

    @Override
    public void deleteContactData(UUID contactId) {
        ContactData contactData = this.getContactById(contactId);
        contactRepository.delete(contactData);
    }
}
