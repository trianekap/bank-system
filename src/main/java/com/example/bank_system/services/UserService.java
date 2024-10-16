package com.example.bank_system.services;

import com.example.bank_system.models.dtos.UserDto;

import java.util.List;

public interface UserService {

    void create(UserDto userDto);
    void update(UserDto userDto);
    void delete(Long id);

    List<UserDto> getAll();
    UserDto getId(Long id);
}
