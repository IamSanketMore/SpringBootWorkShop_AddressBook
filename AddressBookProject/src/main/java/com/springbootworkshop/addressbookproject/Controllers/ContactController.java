package com.springbootworkshop.addressbookproject.Controllers;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.Model.ContactData;
import com.springbootworkshop.addressbookproject.Services.IContactService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/AddressBook/contact")
@Api(value = "Contact-Controller",description = "Perform API Operation on the Contact fields ")
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
        List<ContactData> contactData = iContactService.getAllContactData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("bookId") UUID bookId) {
        ContactData contactData = iContactService.getContactById(bookId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO ) {
        ContactData contactData = iContactService.addContactData(contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{bookId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("bookId") UUID bookId, @Valid @RequestBody ContactDTO contactDTO) {
        ContactData contactData = iContactService.updateContactData(bookId,contactDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Contact Data for", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("bookId") UUID bookId) {
        iContactService.deleteContactData(bookId);
        ResponseDTO respDTO = new ResponseDTO("Delete Call Success for id: ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
