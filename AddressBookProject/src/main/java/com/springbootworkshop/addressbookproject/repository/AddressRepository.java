package com.springbootworkshop.addressbookproject.repository;

import com.springbootworkshop.addressbookproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID>
{
}
