package com.example.bank_system.services.impl;

import com.example.bank_system.models.dtos.UserDto;
import com.example.bank_system.models.entities.User;
import com.example.bank_system.repositories.UserRepository;
import com.example.bank_system.services.UserService;
import com.example.bank_system.util.UserMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void create(UserDto userDto) {

        UserDto userDto1 = new UserDto();
        userDto1.setUsername(userDto.getUsername());
        userDto1.setEmail(userDto.getEmail());
        userDto1.setPassword(userDto.getPassword());
        userDto1.setRole(userDto.getRole());
        userDto1.setCreatedAt(LocalDateTime.now());

        User user = toEntity(userDto1);
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserDto userDto) {

        User user1 = userRepository.findById(id).get();
        if (user1 == null) {
            log.info("user with {} not found!", userDto.getUserId());
            return;
        }

        user1.setUsername(userDto.getUsername());
        user1.setEmail(userDto.getEmail());
        user1.setPassword(userDto.getPassword());
        user1.setRole(UserMapper.convertRole(userDto.getRole()));
        user1.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user1);
    }

    @Override
    public void delete(Long id) {

        User user = userRepository.findById(id).get();

        if (user == null) log.info("user with {} not found!", id);

        userRepository.deleteById(id);

    }

    @Override
    public List<UserDto> getAll() {
        
        List<User> userList = userRepository.findAll();
        
        return userList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getId(Long id) {

        User user = userRepository.findById(id).get();

        return toDto(user);
    }

    private UserDto toDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    private User toEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
}
