package com.springbootworkshop.addressbookproject.model;

import com.springbootworkshop.addressbookproject.DTO.ContactDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "contact")
@Data
public class Contact
{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "contact_id", columnDefinition = "BINARY(16)")
    private UUID contactId;

    private String firstName;
    private String lastName;
    private String gender;
    private String mobileNumber;
    private String emailID;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public Contact() {

    }
    public Contact(ContactDTO contactDTO) {
        super();
        this.firstName = contactDTO.firstName;
        this.lastName = contactDTO.lastName;
        this.gender = contactDTO.gender;
        this.mobileNumber = contactDTO.mobileNumber;
        this.emailID = contactDTO.emailID;
    }
}