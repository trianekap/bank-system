package com.example.bank_system.models.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class LoanDto {

    private Long loanId;

    private UserDto user;

    private BigDecimal amount;

    private BigDecimal interestRate;

    private LoanStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public enum LoanStatus {
        ACTIVE, PAID_OFF, DEFAULT
    }
}
