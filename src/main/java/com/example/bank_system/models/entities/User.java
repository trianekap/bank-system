package com.example.bank_system.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    @NotNull(message = "username cannot be null!")
    @Size(min = 3, message = "username at least have 3 character!")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "password cannot be null!")
    @Size(min = 8, message = "password must be have a minimum 8 character!")
    private String password;

    @Column(nullable = false, unique = true)
    @Email(message = "email invalid format!")
    @NotNull(message = "email cannot be null!")
    private String email;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "role cannot be null!")
    @Pattern(regexp = "CUSTOMER|ADMIN", message = "Role must be either CUSTOMER or ADMIN")
    private String role;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

//    public enum Role {
//        CUSTOMER, ADMIN
//    }
}
