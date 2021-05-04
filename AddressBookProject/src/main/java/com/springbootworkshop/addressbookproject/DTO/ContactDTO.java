package com.springbootworkshop.addressbookproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public @ToString class ContactDTO
{
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = " !!! FirstName Is Invalid !!! " +
            "\n > FirstName Have a Minimum 2 Characters " +
            "\n > First Letter Should be Capital  ")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$" , message = " !!! LastName Is Invalid !!! ")
    public String lastName;

    @Pattern(regexp = "male|female" ,message = "Gender needs to be male and female")
    public String gender;

    @NotNull
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}$",message = "Mobile Number is Invalid")
    public String mobileNumber;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{1,}@[a-zA-Z]{2,6}[.][a-zA-Z]{2,4}$",message = "Email is Invalid")
    public String emailID;

    //public String addressId;
}
