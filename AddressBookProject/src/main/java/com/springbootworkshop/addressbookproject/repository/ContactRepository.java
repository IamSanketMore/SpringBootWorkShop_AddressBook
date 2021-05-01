package com.springbootworkshop.addressbookproject.repository;

import com.springbootworkshop.addressbookproject.Model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<ContactData, UUID>
{
}
