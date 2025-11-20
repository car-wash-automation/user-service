package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.UserDto;
import org.example.userservice.dto.UserRequestDto;
import org.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController implements UserControllerApi{
    private final UserService userService;

    @Override
    public UserDto createUser(UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @Override
    public UserDto getUserById(Long id) {
        return userService.findById(id);
    }

    @Override
    public UserDto updateUserById(Long id, UserRequestDto userRequestDto) {
        return userService.updateById(id, userRequestDto);
    }

    @Override
    public void deleteUserById(Long id) {
        userService.deleteById(id);
    }
}
