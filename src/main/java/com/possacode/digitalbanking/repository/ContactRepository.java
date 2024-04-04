package com.possacode.digitalbanking.repository;


import com.possacode.digitalbanking.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByUserId(Integer id);
}
