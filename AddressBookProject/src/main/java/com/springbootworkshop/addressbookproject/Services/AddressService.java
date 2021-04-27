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
        addressDataList.add(new AddressData(1, new AddressDTO("Deopur Dhule","Dhule","MH",78542187)));
        return addressDataList;
    }

    @Override
    public List<AddressData> getAllAddressData() {
        return addressDataList;
    }

    @Override
    public AddressData getAddressById(int contactId) {
        AddressData addressData = new AddressData(1, new AddressDTO("Deopur Dhule","Dhule","MH",78542187));
        return addressData;
    }

    @Override
    public AddressData addAddressData(AddressDTO addressDTO) {
        AddressData addressData = new AddressData(1, addressDTO);
        return addressData;
    }

    @Override
    public AddressData updateAddressData(int contactId, AddressDTO addressDTO) {
        AddressData addressData = new AddressData(1, addressDTO);
        return addressData;
    }

    @Override
    public AddressData deleteAddressData(int contactId) {
        return null;
    }
}
