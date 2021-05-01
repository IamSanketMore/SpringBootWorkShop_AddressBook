package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;

import java.util.List;
import java.util.UUID;

public interface IContactService
{
    List<ContactData> getContactData();
    List<ContactData> getAllContactData();
    ContactData getContactById(UUID contactId);
    ContactData addContactData(ContactDTO contactDTO);
    ContactData updateContactData(UUID contactId,ContactDTO contactDTO);
    void deleteContactData(UUID contactId);

}
