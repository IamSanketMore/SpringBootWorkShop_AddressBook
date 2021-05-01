package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import java.util.List;
import java.util.UUID;

public interface IAddressService
{
    List<AddressData> getAddressData();
    List<AddressData> getAllAddressData();
    AddressData getAddressById(UUID addressId);
    AddressData addAddressData(AddressDTO addressDTO);
    AddressData updateAddressData(UUID addressId,AddressDTO addressDTO);
    void deleteAddressData(UUID addressId);
}
