package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import java.util.List;

public interface IAddressService
{
    List<AddressData> getAddressData();
    List<AddressData> getAllAddressData();
    AddressData getAddressById(int addressId);
    AddressData addAddressData(AddressDTO addressDTO);
    AddressData updateAddressData(int addressId,AddressDTO addressDTO);
    void deleteAddressData(int addressId);
}
