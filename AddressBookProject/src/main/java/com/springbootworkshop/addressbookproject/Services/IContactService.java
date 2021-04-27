package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;

import java.util.List;

public interface IContactService
{
    List<ContactData> getContactData();
    List<ContactData> getAllContactData();
    ContactData getContactById(int contactId);
    ContactData addContactData(ContactDTO contactDTO);
    ContactData updateContactData(int contactId,ContactDTO contactDTO);
    ContactData deleteContactData(int contactId);

}
