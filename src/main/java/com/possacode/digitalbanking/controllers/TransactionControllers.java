package com.possacode.digitalbanking.controllers;


import com.possacode.digitalbanking.dtO.TransactionDto;
import com.possacode.digitalbanking.sevices.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digibank/v1/transaction")
@RequiredArgsConstructor
public class TransactionControllers {

    private final TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<Integer> save(@RequestBody TransactionDto transactionDto){
        return ResponseEntity.ok(transactionService.save(transactionDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<TransactionDto>> findAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<List<TransactionDto>> findAllByUserId(@PathVariable("transactionId") Integer id){
        return ResponseEntity.ok(transactionService.findAllByUserId(id));
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionDto> findById(@PathVariable("transactionId") Integer id){
        return ResponseEntity.ok(transactionService.findById(id));
    }


    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> delete(@PathVariable("transactionId") Integer id){
        transactionService.delete(id);
        return ResponseEntity.accepted().build();
    }





}
