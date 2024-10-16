package com.example.bank_system.models.dtos;

import com.example.bank_system.models.entities.User;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountDto {

    private Long accountId;

    private UserDto user;

    private String accountNumber;

    private AccountType accountType;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public enum AccountType {
        SAVINGS, CHECKING, LOAN
    }
}
