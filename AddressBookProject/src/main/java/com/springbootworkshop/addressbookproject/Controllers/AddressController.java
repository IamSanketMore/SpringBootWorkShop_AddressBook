package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import com.springbootworkshop.addressbookproject.Services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController
{
    @Autowired
    private IAddressService iAddressService;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getAddressData()
    {
        List<AddressData> addressData = iAddressService.getAddressData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllAddressData" )
    public ResponseEntity<ResponseDTO> getAllAddressData() {
        List<AddressData> addressData = iAddressService.getAllAddressData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("bookId") int bookId) {
        AddressData addressData  = iAddressService.getAddressById(bookId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<ResponseDTO> addAddressData(@RequestBody AddressDTO addressDTO) {
        AddressData addressData = iAddressService.addAddressData(addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<ResponseDTO> updateAddressData(@RequestBody AddressDTO addressDTO) {
        AddressData addressData = iAddressService.updateAddressData(1, addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{bookId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("bookId") int bookId) {
        AddressData addressData = iAddressService.deleteAddressData(1);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
