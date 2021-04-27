package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContactService
{
    List<ContactData> contactDataListList = new ArrayList<ContactData>();
    @Override
    public List<ContactData> getContactData() {

        contactDataListList.add(new ContactData(1, new ContactDTO("Sanket", "More","Male",425005,"Sanket@123")));
        return contactDataListList;
    }

    @Override
    public List<ContactData> getAllContactData() {
        return contactDataListList;
    }

    @Override
    public ContactData getContactById(int contactId) {
        ContactData contactData = new ContactData(1,new ContactDTO("Sanket", "More","Male",425005,"Sanket@123"));
        return contactData;
    }

    @Override
    public ContactData addContactData(ContactDTO contactDTO) {
        ContactData contactData = new ContactData(1,contactDTO);
        return contactData;
    }

    @Override
    public ContactData updateContactData(int contactId, ContactDTO contactDTO) {
        ContactData contactData = new ContactData(1,contactDTO);
        return contactData;
    }

    @Override
    public ContactData deleteContactData(int contactId) {
        return null;
    }
}
