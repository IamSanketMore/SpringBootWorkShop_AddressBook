package com.springbootworkshop.addressbookproject.controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.model.Address;
import com.springbootworkshop.addressbookproject.services.IAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/AddressBook/address")
@Api(value = "Address-Controller",description = "Perform API Operation on the ADDRESS fields ")
public class AddressController
{
    @Autowired
    private IAddressService iAddressService;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getAddressData()
    {
        List<Address> addressData = iAddressService.getAddressData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAll" )
    public ResponseEntity<ResponseDTO> getAllAddressData() {
        List<Address> addressData = iAddressService.getAllAddressData();
        ResponseDTO respDTO = new ResponseDTO("Get All Address", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("bookId") UUID bookId) {
        Address address = iAddressService.getAddressById(bookId);
        ResponseDTO respDTO = new ResponseDTO("Get Address by Id ", address);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<ResponseDTO> addAddressData(@Valid @RequestBody AddressDTO addressDTO) {
        Address address = iAddressService.addAddressData(addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Address Created Successfully : ", address);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAddress/{bookId}")
    public ResponseEntity<ResponseDTO> updateAddressData(@PathVariable("bookId") UUID bookId,@Valid @RequestBody AddressDTO addressDTO) {
        Address address = iAddressService.updateAddressData(bookId, addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Address UpDated Successfully : ", address);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{bookId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("bookId") UUID bookId) {
        iAddressService.deleteAddressData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Address Deleted Successfully : ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping(value = { "/sortByCity" })
    public ResponseEntity<ResponseDTO> sortBycityName() {
        List<Address> addressData =iAddressService.sortBycityName();
        ResponseDTO responseDTO = new ResponseDTO(" Sort By City Name ", addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = { "/sortByState" })
    public ResponseEntity<ResponseDTO> sortBystateName() {
        List<Address> addressData =iAddressService.sortBystateName();
        ResponseDTO responseDTO = new ResponseDTO(" Sort By State Name :", addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
