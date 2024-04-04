package com.possacode.digitalbanking.controllers;


import com.possacode.digitalbanking.dtO.AdressDto;
import com.possacode.digitalbanking.sevices.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibank/v1/adress")
@RequiredArgsConstructor
public class AdressControllers {

    private final AdressService adressService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AdressDto adressDto){
        return ResponseEntity.ok(adressService.save(adressDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AdressDto>> findAll(){
        return ResponseEntity.ok(adressService.findAll());
    }

    @GetMapping("/{adresseId}")
    public ResponseEntity<AdressDto> findById(@PathVariable("adresseId") Integer id ){
        return ResponseEntity.ok(adressService.findById(id));
    }

    @DeleteMapping("/{adresseId}")
    public ResponseEntity<Void> delete(@PathVariable("adresseId") Integer id){
        adressService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
