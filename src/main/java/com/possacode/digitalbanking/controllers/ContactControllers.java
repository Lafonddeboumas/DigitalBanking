package com.possacode.digitalbanking.controllers;

import com.possacode.digitalbanking.dtO.ContactDto;
import com.possacode.digitalbanking.sevices.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibank/v1/contact")
@RequiredArgsConstructor
public class ContactControllers {


    private final ContactService contactService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody ContactDto contactDto){
        return ResponseEntity.ok(contactService.save(contactDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ContactDto>> findAll(){
        return ResponseEntity.ok(contactService.findAll());
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<List<ContactDto>> findAllByUserId(@PathVariable("contactId") Integer id){
        return ResponseEntity.ok(contactService.findAllByUserId(id));
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDto> findById(@PathVariable("contactId") Integer id){
        return ResponseEntity.ok(contactService.findById(id));
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> delete(@PathVariable("contactId") Integer id){
        contactService.delete(id);
        return ResponseEntity.accepted().build();
    }

}
