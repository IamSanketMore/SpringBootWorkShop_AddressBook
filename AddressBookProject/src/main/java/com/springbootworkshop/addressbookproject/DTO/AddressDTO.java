package com.springbootworkshop.addressbookproject.DTO;

import lombok.ToString;

public @ToString class AddressDTO
{
    public String address;
    public String city;
    public String state;
    public int zip;

    public AddressDTO(String address, String city, String state, int zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}
