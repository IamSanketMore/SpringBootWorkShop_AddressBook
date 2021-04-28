package com.springbootworkshop.addressbookproject.DTO;

import lombok.ToString;

import javax.validation.constraints.Email;

public @ToString class ContactDTO
{
    public String firstName;
    public String lastName;
    public String gender;
    public int mobileNumber;

    public String emailID;

    public ContactDTO(String firstName, String lastName, String gender, int mobileNumber, String emailID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
    }
}
