package com.springbootworkshop.addressbookproject.services;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.model.Address;
import com.springbootworkshop.addressbookproject.exceptions.AddressException;
import com.springbootworkshop.addressbookproject.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService implements IAddressService
{
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAddressData()
    {
        return addressRepository.findAll();
    }

    @Override
    public List<Address> getAllAddressData() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(UUID addressId) {
       return  addressRepository.findById(addressId)
               .orElseThrow(() -> new AddressException("Address With addressID " +
                       addressId +"does not exists"));
    }

    @Override
    public Address addAddressData(AddressDTO addressDTO) {
        Address address = new Address(addressDTO);
        //ContactData contactData = new ContactData();
        address.setCreatedTimeStamp(LocalDateTime.now());
        //addressData.setContactData(contactData);
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddressData(UUID addressId, AddressDTO addressDTO) {
        Address address = this.getAddressById(addressId);
        address.setAddress(addressDTO.address);
        address.setCity(addressDTO.city);
        address.setState(addressDTO.state);
        address.setZip(addressDTO.zip);
        address.setUpdatedTimeStamp(LocalDateTime.now());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressData(UUID  addressId) {
      Address address = this.getAddressById(addressId);
      addressRepository.delete(address);
    }

    @Override
    public List<Address> sortBycityName() {
        return addressRepository.findAll((Sort.by("city").ascending()));
    }

    @Override
    public List<Address> sortBystateName() {
        return  addressRepository.findAll((Sort.by("state").ascending()));
    }

}
