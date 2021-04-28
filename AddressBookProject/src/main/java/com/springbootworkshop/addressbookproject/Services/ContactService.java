package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import com.springbootworkshop.addressbookproject.exceptions.ContactException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContactService
{
    List<ContactData> contactDataList = new ArrayList<ContactData>();
    @Override
    public List<ContactData> getContactData() {
        return contactDataList;
    }

    @Override
    public List<ContactData> getAllContactData() {
        return contactDataList;
    }

    @Override
    public ContactData getContactById(int contactId) {
        return contactDataList.stream()
                .filter(contactData -> contactData.getContactId() == contactId)
                .findFirst().orElseThrow(() -> new ContactException("Contact ID Not Found"));
    }

    @Override
    public ContactData addContactData(ContactDTO contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(contactDataList.size()+1,contactDTO);
        contactDataList.add(contactData);
        return contactData;
    }

    @Override
    public ContactData updateContactData(int contactId, ContactDTO contactDTO) {
        ContactData contactData = this.getContactById(contactId);
        contactData.setFirstName(contactDTO.firstName);
        contactData.setLastName(contactDTO.lastName);
        contactData.setGender(contactDTO.gender);
        contactData.setMobileNumber(contactDTO.mobileNumber);
        contactData.setEmailID(contactDTO.emailID);
        contactDataList.set(contactId-1,contactData);
        return contactData;
    }

    @Override
    public void deleteContactData(int contactId) {
        contactDataList.remove(contactId-1);
    }
}
