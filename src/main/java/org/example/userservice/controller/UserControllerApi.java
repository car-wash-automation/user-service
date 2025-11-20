package org.example.userservice.controller;

import java.util.List;
import org.example.userservice.dto.UserDto;
import org.example.userservice.dto.UserRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface UserControllerApi {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserDto createUser(@RequestBody UserRequestDto userRequestDto);

    @GetMapping
    List<UserDto> getAllUsers();

    @GetMapping("/{id}")
    UserDto getUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    UserDto updateUserById(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id);
}
