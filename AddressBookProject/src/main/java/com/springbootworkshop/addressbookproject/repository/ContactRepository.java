package com.springbootworkshop.addressbookproject.repository;

import com.springbootworkshop.addressbookproject.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID>
{
}
