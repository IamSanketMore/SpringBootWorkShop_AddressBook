package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import java.util.List;

public interface IAddressService
{
    List<AddressData> getAddressData();
    List<AddressData> getAllAddressData();
    AddressData getAddressById(int contactId);
    AddressData addAddressData(AddressDTO addressDTO);
    AddressData updateAddressData(int contactId,AddressDTO addressDTO);
    AddressData deleteAddressData(int contactId);
}
