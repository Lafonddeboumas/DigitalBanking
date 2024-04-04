package com.possacode.digitalbanking.controllers;


import com.possacode.digitalbanking.dtO.AccountDto;
import com.possacode.digitalbanking.sevices.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibank/v1/account")
@RequiredArgsConstructor
public class AccountControllers {

    private final AccountService accountService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody AccountDto accountDto){
        return ResponseEntity.ok(accountService.save(accountDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AccountDto>> findAll() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountDto> findById(@PathVariable("account-id") Integer accountId){
        return ResponseEntity.ok(accountService.findById(accountId));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void>  delete(@PathVariable("accountId") Integer id){
        accountService.delete(id);
        return ResponseEntity.accepted().build();
    }


}
