package com.example.bank_system.models.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long userId;

    private String username;

    private String password;

    private String email;

    private Role role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public enum Role {
        CUSTOMER, ADMIN
    }
}
