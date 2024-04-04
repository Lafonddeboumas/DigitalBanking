package com.possacode.digitalbanking.controllers;

import com.possacode.digitalbanking.sevices.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digibank/v1/contact")
@RequiredArgsConstructor
public class ContactControllers {


    private final ContactService contactService;


}
