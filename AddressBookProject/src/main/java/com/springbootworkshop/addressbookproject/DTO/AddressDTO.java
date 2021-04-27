package com.springbootworkshop.addressbookproject.DTO;

public class AddressDTO
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

    @Override
    public String toString() {
        return "AddressDTO{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
