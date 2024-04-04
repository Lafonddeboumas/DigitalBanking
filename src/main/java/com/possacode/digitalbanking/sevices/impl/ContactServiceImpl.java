package com.possacode.digitalbanking.sevices.impl;


import com.possacode.digitalbanking.dtO.ContactDto;
import com.possacode.digitalbanking.models.Contact;
import com.possacode.digitalbanking.repository.ContactRepository;
import com.possacode.digitalbanking.sevices.ContactService;
import com.possacode.digitalbanking.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ObjectsValidator<ContactDto> validator;

    @Override
    public Integer save(ContactDto dto) {
        validator.validate(dto);
        Contact contact = ContactDto.toEntity(dto);
        return contactRepository.save(contact).getId();
    }

    @Override
    public List<ContactDto> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Integer id) {
        return contactRepository.findById(id)
                .map(ContactDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No contact found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<ContactDto> findAllByUserId(Integer id) {
        return contactRepository.findAllByUserId(id).stream()
                .map(ContactDto::fromEntity)
                .collect(Collectors.toList());
    }
}
