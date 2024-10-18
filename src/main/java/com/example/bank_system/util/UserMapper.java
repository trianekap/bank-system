//package com.example.bank_system.util;
//
//import com.example.bank_system.models.dtos.UserDto;
//import com.example.bank_system.models.entities.User;
//
//public class UserMapper {
//
//    public static User.Role convertRole(UserDto.Role roleDto) {
//        if (roleDto == null) {
//            throw new IllegalArgumentException("Role cannot be null");
//        }
//
//        switch (roleDto) {
//            case ADMIN:
//                return User.Role.ADMIN;
//            case CUSTOMER:
//                return User.Role.CUSTOMER;
//            default:
//                throw new IllegalArgumentException("Unknown role: " + roleDto);
//        }
//    }
//}
//
