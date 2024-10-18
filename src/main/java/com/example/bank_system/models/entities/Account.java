package com.example.bank_system.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "user cannot be null!")
    private User user;

    @Column(name = "account_number", nullable = false, unique = true)
    @NotNull(message = "account number cannot be null!")
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "account type cannot be null!")
    private AccountType accountType;

    @Column(nullable = false)
    @NotNull(message = "balance cannot be null!")
    @Size(min = 0)
    private BigDecimal balance;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum AccountType {
        SAVINGS, CHECKING, LOAN
    }
}
