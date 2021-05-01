package com.springbootworkshop.addressbookproject.Model;

import com.springbootworkshop.addressbookproject.DTO.AddressDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address_data")
public @Data class AddressData
{
    @Id
    //private int addressId;
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID addressId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public AddressData( AddressDTO addressDTO) {
        super();

        this.address = addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zip = addressDTO.zip;
    }

    public AddressData() {

    }

}
