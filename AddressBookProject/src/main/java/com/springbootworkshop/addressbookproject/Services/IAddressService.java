package com.springbootworkshop.addressbookproject.services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.model.Address;
import java.util.List;
import java.util.UUID;

public interface IAddressService
{
    List<Address> getAddressData();
    List<Address> getAllAddressData();
    Address getAddressById(UUID addressId);
    Address addAddressData(AddressDTO addressDTO);
    Address updateAddressData(UUID addressId, AddressDTO addressDTO);
    void deleteAddressData(UUID addressId);
    List<Address> sortBycityName();

    List<Address> sortBystateName();
}
