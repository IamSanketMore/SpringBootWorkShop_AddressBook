package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController
{
    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllAddressData" )
    public ResponseEntity<String> getAllAddressData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<String> getAddressById(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<String>("Get Call Success for id: " + bookId, HttpStatus.OK);
    }

    @PostMapping("/createAddress")
    public ResponseEntity<String> addAddressData(@RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<String>("Created address Book Data for: " + addressDTO, HttpStatus.OK);
    }

    @PutMapping("/updateAddress")
    public ResponseEntity<String> updateAddressData(@RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<String>("Updated address Book Data for: " + addressDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<String> deleteAddressData(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<String>("Delete Call Success for id: " + bookId, HttpStatus.OK);
    }
}
