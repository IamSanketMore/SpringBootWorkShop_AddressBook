package com.springbootworkshop.addressbookproject.Model;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import lombok.Data;

import java.time.LocalDateTime;

public @Data class ContactData {
    private int contactId;
    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;
    private String emailID;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;


    public ContactData(int contactId, ContactDTO contactDTO) {
        super();
        this.contactId = contactId;
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.gender = contactDTO.gender;
        this.mobileNumber = contactDTO.mobileNumber;
        this.emailID = contactDTO.emailID;
    }
}