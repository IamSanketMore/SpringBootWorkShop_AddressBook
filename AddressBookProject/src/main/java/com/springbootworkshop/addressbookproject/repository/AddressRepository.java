package com.springbootworkshop.addressbookproject.repository;

import com.springbootworkshop.addressbookproject.Model.AddressData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<AddressData, UUID>
{
}
