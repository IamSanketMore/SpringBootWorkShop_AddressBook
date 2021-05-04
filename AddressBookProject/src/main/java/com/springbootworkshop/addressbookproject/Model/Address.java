package com.springbootworkshop.addressbookproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
public class Address
{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "address_id", columnDefinition = "BINARY(16)")
    private UUID addressId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "address")
    @JsonIgnore
    private Contact contact;

    public Address(AddressDTO addressDTO) {
        super();

        this.address = addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zip = addressDTO.zip;
    }
    public Address()
    {

    }
}
