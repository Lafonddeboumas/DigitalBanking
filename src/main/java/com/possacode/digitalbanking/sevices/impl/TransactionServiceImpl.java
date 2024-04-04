package com.possacode.digitalbanking.sevices.impl;


import com.possacode.digitalbanking.dtO.TransactionDto;
import com.possacode.digitalbanking.models.Transaction;
import com.possacode.digitalbanking.models.TransactionType;
import com.possacode.digitalbanking.repository.TransactionRepository;
import com.possacode.digitalbanking.sevices.TransactionService;
import com.possacode.digitalbanking.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ObjectsValidator<TransactionDto> validator;

    @Override
    public Integer save(TransactionDto dto) {
        validator.validate(dto);
        Transaction transaction  = TransactionDto.toEntity(dto);
        BigDecimal transactionMultiplier = BigDecimal.valueOf(getTransactionMultiplier(transaction.getTransactionType()));
        BigDecimal amount = transaction.getAmount().multiply(transactionMultiplier);
        transaction.setAmount(amount);
        return transactionRepository.save(transaction).getId();
    }

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public TransactionDto findById(Integer id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No transaction was found with the ID: " + id));
    }

    @Override
    public void delete(Integer id) {
            transactionRepository.deleteById(id);
    }

    private int getTransactionMultiplier(TransactionType type) {
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }

    @Override
    public List<TransactionDto> findAllByUserId(Integer id) {
        return transactionRepository.findAllByUserId(id)
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList())
                ;
    }
}
