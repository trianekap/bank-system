package com.example.bank_system.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class TransactionDto {

    private Long transactionId;

    private AccountDto account;

    private TransactionType transactionType;

    private BigDecimal amount;

    private LocalDateTime transactionDate;

    private String description;

    public enum TransactionType {
        DEPOSIT, WITHDRAW, TRANSFER
    }
}
