package com.possacode.digitalbanking.dtO;


import com.possacode.digitalbanking.models.Transaction;
import com.possacode.digitalbanking.models.TransactionType;
import com.possacode.digitalbanking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class
TransactionDto {

    private Integer id;

    private BigDecimal amount;

    private String destinationIban;

    private LocalDate transactionDate;

    private TransactionType transactionType;
    private Integer userId;

    public static TransactionDto fromEntity(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .transactionType(transaction.getTransactionType())
                .transactionDate(transaction.getTransactionDate())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getId())
                .build();
    }

    public static Transaction toEntity(TransactionDto transactionDto){
        return Transaction.builder()
                .id(transactionDto.getId())
                .amount(transactionDto.getAmount())
                .transactionType(transactionDto.getTransactionType())
                .transactionDate(transactionDto.getTransactionDate())
                .destinationIban(transactionDto.getDestinationIban())
                .user(
                        User.builder()
                                .id(transactionDto.getUserId())
                                .build()
                )
                .build();
    }


}
