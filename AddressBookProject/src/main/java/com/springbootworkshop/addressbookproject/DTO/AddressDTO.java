package com.springbootworkshop.addressbookproject.DTO;

import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @ToString class AddressDTO
{
    @NotBlank
    public String address;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{2,}$",message = "!!! Invalid City Name !!! " )
    public String city;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{2,}$",message = "!!! Invalid State Name !!! ")
    public String state;

    @NotNull
    @Pattern(regexp = "^[1-9]{1}[0-9]{5}$",message = "!!!Invalid Zip Code!!!")
    public String zip;

    public AddressDTO(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
