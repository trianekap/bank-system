package com.example.bank_system.services.impl;

import com.example.bank_system.models.dtos.UserDto;
import com.example.bank_system.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void create(UserDto userDto) {

    }

    @Override
    public void update(UserDto userDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        return Collections.emptyList();
    }

    @Override
    public UserDto getId(Long id) {
        return null;
    }
}
