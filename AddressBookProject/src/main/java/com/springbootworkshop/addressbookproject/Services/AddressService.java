package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements IAddressService
{
    List<AddressData> addressDataList = new ArrayList<AddressData>();
    @Override
    public List<AddressData> getAddressData() {
        return addressDataList;
    }

    @Override
    public List<AddressData> getAllAddressData() {
        return addressDataList;
    }

    @Override
    public AddressData getAddressById(int addressId) {
       return  addressDataList.get(addressId-1);
    }

    @Override
    public AddressData addAddressData(AddressDTO addressDTO) {
        AddressData addressData = null;
        addressData = new AddressData(addressDataList.size()+1, addressDTO);
        addressDataList.add(addressData);
        return addressData;
    }

    @Override
    public AddressData updateAddressData(int addressId, AddressDTO addressDTO) {
        AddressData addressData = this.getAddressById(addressId);
        addressData.setAddress(addressDTO.address);
        addressData.setCity(addressDTO.city);
        addressData.setState(addressDTO.state);
        addressData.setZip(addressDTO.zip);
        addressDataList.set(addressId-1,addressData);
        return addressData;
    }

    @Override
    public void deleteAddressData(int  addressId) {
      addressDataList.remove(addressId-1);
    }
}
