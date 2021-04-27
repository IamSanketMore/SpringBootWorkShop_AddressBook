package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import com.springbootworkshop.addressbookproject.Services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController
{
    @Autowired
    private IContactService iContactService;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {
        List<ContactData> contactData = iContactService.getContactData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAllContactData" )
    public ResponseEntity<ResponseDTO> getAllContactData() {
        List<ContactData> contactData = iContactService.getContactData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("bookId") int bookId) {
        List<ContactData> contactData = iContactService.getContactData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public ResponseEntity<ResponseDTO> addContactData(@RequestBody ContactDTO contactDTO ) {
        ContactData contactData = iContactService.addContactData(contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{bookId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("bookId") int bookId,@RequestBody ContactDTO contactDTO) {
        ContactData contactData = iContactService.updateContactData(1,contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("bookId") int bookId) {
        ContactData contactData = iContactService.deleteContactData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
