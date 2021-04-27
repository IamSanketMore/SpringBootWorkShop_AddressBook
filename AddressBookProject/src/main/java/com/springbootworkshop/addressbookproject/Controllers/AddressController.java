package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController
{
    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getAddressBookData()
    {
            AddressData addressData = null;
            addressData = new AddressData(1, new AddressDTO("Deopur Dhule","Dhule","MH",78542187));
            ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
            return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllAddressData" )
    public ResponseEntity<String> getAllAddressData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("bookId") int bookId) {
        AddressData addressData = null;
        addressData = new AddressData(1, new AddressDTO("Deopur Dhule","Dhule","MH",78542187));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<ResponseDTO> addAddressData(@RequestBody AddressDTO addressDTO) {
        AddressData addressData = null;
        addressData = new AddressData(1,addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<ResponseDTO> updateAddressData(@RequestBody AddressDTO addressDTO) {
        AddressData addressData = null;
        addressData = new AddressData(1,addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{bookId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("bookId") int bookId) {
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
