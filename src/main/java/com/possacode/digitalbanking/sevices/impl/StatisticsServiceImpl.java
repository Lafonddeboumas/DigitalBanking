package com.possacode.digitalbanking.sevices.impl;


import com.possacode.digitalbanking.dtO.TransactionSumDetails;
import com.possacode.digitalbanking.models.TransactionType;
import com.possacode.digitalbanking.repository.TransactionRepository;
import com.possacode.digitalbanking.sevices.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final TransactionRepository transactionRepository;

    @Override
    public List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Integer userId) {
        return null;
    }

    @Override
    public BigDecimal getAccountBalance(Integer userId) {
        return transactionRepository.findAccountBalance(userId);
    }

    @Override
    public BigDecimal highestTransfer(Integer userId) {
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.TRANSFERT);
    }

    @Override
    public BigDecimal highestDeposit(Integer userId) {
        return transactionRepository.findHighestAmountByTransactionType(userId, TransactionType.DEPOT);
    }
}
