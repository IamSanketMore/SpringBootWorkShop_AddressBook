package com.springbootworkshop.addressbookproject.Model;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import lombok.Data;

public @Data class AddressData
{
    private int addressId;
    private String address;
    private String city;
    private String state;
    private int zip;

    public AddressData(int addressId, AddressDTO addressDTO) {
        super();
        this.addressId = addressId;
        this.address = addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zip = addressDTO.zip;
    }
}
