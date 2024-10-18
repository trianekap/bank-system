package com.example.bank_system.controllers;

import com.example.bank_system.models.dtos.UserDto;
import com.example.bank_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String create(@Valid @RequestBody UserDto userDto) {
        userService.create(userDto);

        return "user has been created!";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid @RequestBody UserDto userDto){
        userService.update(id, userDto);

        return "user has been updated!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);

        return "user has been deleted!";
    }

    @GetMapping("/getAll")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("getId/{id}")
    public UserDto getId(@PathVariable Long id){

        UserDto userDto = userService.getId(id);

        return userDto;
    }

}
