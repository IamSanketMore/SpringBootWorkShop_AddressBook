package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController
{
    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {
        ContactData contactData = null;
        contactData = new ContactData(1,new ContactDTO("Sanket","More","Male",787887787,"sanket@123"));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllContactData" )
    public ResponseEntity<ResponseDTO> getAllContactData() {
        ContactData contactData = null;
        contactData = new ContactData(1,new ContactDTO("Sanket","More","Male",787887787,"sanket@123"));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("bookId") int bookId) {
        ContactData contactData = null;
        contactData = new ContactData(1,new ContactDTO("Sanket","More","Male",787887787,"sanket@123"));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public ResponseEntity<ResponseDTO> addContactData(@RequestBody ContactDTO contactDTO ) {
        ContactData contactData = null;
        contactData = new ContactData(1,contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateContact")
    public ResponseEntity<ResponseDTO> updateContactData(@RequestBody ContactDTO contactDTO) {
        ContactData contactData = null;
        contactData = new ContactData(1,contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("bookId") int bookId) {
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
