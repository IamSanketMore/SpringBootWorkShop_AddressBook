package com.springbootworkshop.addressbookproject.Services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import com.springbootworkshop.addressbookproject.exceptions.AddressException;
import com.springbootworkshop.addressbookproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService implements IAddressService
{
    @Autowired
    private AddressRepository addressRepository;
    List<AddressData> addressDataList = new ArrayList<AddressData>();
    @Override
    public List<AddressData> getAddressData() {
        return addressRepository.findAll();
    }

    @Override
    public List<AddressData> getAllAddressData() {
        return addressRepository.findAll();
    }

    @Override
    public AddressData getAddressById(UUID addressId) {
       return  addressRepository.findById(addressId)
               .orElseThrow(() -> new AddressException("Address With addressID " +
                       addressId +"does not exists"));
    }

    @Override
    public AddressData addAddressData(AddressDTO addressDTO) {
        AddressData addressData = new AddressData(addressDTO);
        addressData.setCreatedTimeStamp(LocalDateTime.now());
        return addressRepository.save(addressData);
    }

    @Override
    public AddressData updateAddressData(UUID addressId, AddressDTO addressDTO) {
        AddressData addressData = this.getAddressById(addressId);
        addressData.setAddress(addressDTO.address);
        addressData.setCity(addressDTO.city);
        addressData.setState(addressDTO.state);
        addressData.setZip(addressDTO.zip);
        addressData.setUpdatedTimeStamp(LocalDateTime.now());
        return addressRepository.save(addressData);
    }

    @Override
    public void deleteAddressData(UUID  addressId) {
      AddressData addressData = this.getAddressById(addressId);
      addressRepository.delete(addressData);
    }

    @Override
    public List<AddressData> sortBycityName() {
        return addressRepository.findAll((Sort.by("city").ascending()));
    }
}
