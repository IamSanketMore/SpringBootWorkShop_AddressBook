package com.springbootworkshop.addressbookproject.controllers;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import com.springbootworkshop.addressbookproject.DTO.ResponseDTO;
import com.springbootworkshop.addressbookproject.model.Contact;
import com.springbootworkshop.addressbookproject.services.IAddressService;
import com.springbootworkshop.addressbookproject.services.IContactService;
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
    @Autowired
    private IAddressService iAddressService;

    @GetMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {
        List<Contact> contactData = iContactService.getContactData();
        ResponseDTO respDTO = new ResponseDTO(" Get Contact SuccessFully ", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping(value =  "/getAll" )
    public ResponseEntity<ResponseDTO> getAllContactData() {
        List<Contact> contactData = iContactService.getAllContactData();
        ResponseDTO respDTO = new ResponseDTO(" Get All Contact ", contactData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{bookId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable("bookId") UUID bookId) {
        Contact contact = iContactService.getContactById(bookId);
        ResponseDTO respDTO = new ResponseDTO(" Get a Contact By Id", contact);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/createContact")
    public ResponseEntity<ResponseDTO> addContactData(@Valid @RequestBody ContactDTO contactDTO ) {
        Contact contact = iContactService.addContactData(contactDTO);
        ResponseDTO respDTO = new ResponseDTO(" Contact Created Successfully : ", contact);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{bookId}")
    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("bookId") UUID bookId, @Valid @RequestBody ContactDTO contactDTO) {
        Contact contact = iContactService.updateContactData(bookId,contactDTO);
        ResponseDTO respDTO = new ResponseDTO(" Contact Updated Successfully : ", contact);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContact/{bookId}")
    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("bookId") UUID bookId) {
        iContactService.deleteContactData(bookId);
        ResponseDTO respDTO = new ResponseDTO(" Contact Deleted Successfully : ", bookId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    @GetMapping("/allAddress")
    public ResponseEntity<ResponseDTO> addAllAddressToContact( @RequestParam ("contactId") String contactId,@RequestParam ("addressId") String addressId) {
        ResponseDTO responseDTO = new ResponseDTO("Created New Contact!",
                iContactService.addAllAddressToContact(contactId, addressId));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

    @GetMapping("/ManyToOne")
    public ResponseEntity<ResponseDTO> addContactToAddress( @RequestParam ("contactId") String contactId,@RequestParam ("addressId") String addressId) {
        ResponseDTO responseDTO = new ResponseDTO("Created New Contact!",
                iContactService.addContactToAddress(contactId, addressId));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

    }

}
