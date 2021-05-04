package com.springbootworkshop.addressbookproject.services;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.model.Address;
import com.springbootworkshop.addressbookproject.model.Contact;
import java.util.List;
import java.util.UUID;

public interface IContactService
{
    List<Contact> getContactData();
    List<Contact> getAllContactData();
    Contact getContactById(UUID contactId);
    Contact addContactData(ContactDTO contactDTO);
    Contact updateContactData(UUID contactId, ContactDTO contactDTO);
    void deleteContactData(UUID contactId);

    List<Address>  addAllAddressToContact(String contactId, String addressId);
}
