package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.AddressData;
import com.springbootworkshop.addressbookproject.Services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("bookId") UUID bookId) {
        AddressData addressData  = iAddressService.getAddressById(bookId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<ResponseDTO> addAddressData(@Valid @RequestBody AddressDTO addressDTO) {
        AddressData addressData = iAddressService.addAddressData(addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAddress/{bookId}")
    public ResponseEntity<ResponseDTO> updateAddressData(@PathVariable("bookId") UUID bookId,@Valid @RequestBody AddressDTO addressDTO) {
        AddressData addressData = iAddressService.updateAddressData(bookId, addressDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Address Data for: ", addressData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAddress/{bookId}")
    public ResponseEntity<ResponseDTO> deleteAddressData(@PathVariable("bookId") UUID bookId) {
        iAddressService.deleteAddressData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping(value = { "/sortByCity" })
    public ResponseEntity<ResponseDTO> sortBycityName() {
        List<AddressData> addressData =iAddressService.sortBycityName();
        ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = { "/sortByState" })
    public ResponseEntity<ResponseDTO> sortBystateName() {
        List<AddressData> addressData =iAddressService.sortBystateName();
        ResponseDTO responseDTO = new ResponseDTO("Successfull got the data", addressData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
