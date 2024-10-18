package com.example.bank_system.models.dtos;

import com.example.bank_system.models.entities.User;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class UserDto {

    private Long userId;

    @NotNull(message = "username cannot be null!")
    @Size(min = 3, message = "username at least have 3 characters!")
    private String username;

    @NotNull(message = "password cannot be null!")
    @Size(min = 8, message = "password must have a minimum of 8 characters!")
    private String password;

    @Email(message = "email invalid format!")
    @NotNull(message = "email cannot be null!")
    private String email;

    @NotNull(message = "role cannot be null!")
    private String role;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
