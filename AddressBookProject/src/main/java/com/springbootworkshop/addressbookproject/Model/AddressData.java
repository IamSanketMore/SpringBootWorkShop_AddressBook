package com.springbootworkshop.addressbookproject.Model;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;

public class AddressData
{
    private int addressId;
    private String address;
    private String city;
    private String state;
    private int zip;

    public AddressData(int contactId, AddressDTO addressDTO) {
        super();
        this.addressId = addressId;
        this.address = addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zip = addressDTO.zip;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

}
