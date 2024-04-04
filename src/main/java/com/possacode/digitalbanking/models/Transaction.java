package com.possacode.digitalbanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction extends AbstractEntity {

    private BigDecimal amount;

    private String destinationIban;

    private LocalDate transactionDate;

    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
