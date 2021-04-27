package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController
{
    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<String> getAddressBookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllContactData" )
    public ResponseEntity<String> getAllContactData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }
    @GetMapping("/get/{bookId}")
    public ResponseEntity<String> getContactById(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<String>("Get Call Success for id: " + bookId, HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public ResponseEntity<String> addContactData(@RequestBody ContactDTO contactDTO ) {
        return new ResponseEntity<String>("Created address Book Data for: " + contactDTO, HttpStatus.OK);
    }

    @PutMapping("/updateContact")
    public ResponseEntity<String> updateContactData(@RequestBody ContactDTO contactDTO) {
        return new ResponseEntity<String>("Updated address Book Data for: " + contactDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<String> deleteContactData(@PathVariable("bookId") int bookId) {
        return new ResponseEntity<String>("Delete Call Success for id: " + bookId, HttpStatus.OK);
    }
}
