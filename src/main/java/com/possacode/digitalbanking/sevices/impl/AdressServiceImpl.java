package com.possacode.digitalbanking.sevices.impl;


import com.possacode.digitalbanking.dtO.AdressDto;
import com.possacode.digitalbanking.models.Adress;
import com.possacode.digitalbanking.repository.AdressRepository;
import com.possacode.digitalbanking.sevices.AdressService;
import com.possacode.digitalbanking.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;
    private final ObjectsValidator<AdressDto> validator;

    @Override
    public Integer save(AdressDto adressDto) {
        validator.validate(adressDto);
        Adress address = AdressDto.toEntity(adressDto);
        return adressRepository.save(address).getId();
    }

    @Override
    public List<AdressDto> findAll() {
        return adressRepository.findAll()
                .stream()
                .map(AdressDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdressDto findById(Integer id) {
        return adressRepository.findById(id)
                .map(AdressDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No address found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        adressRepository.deleteById(id);
    }
}
