package org.example.userservice.service;

import java.util.List;
import org.example.userservice.dto.UserDto;
import org.example.userservice.dto.UserRequestDto;

public interface UserService {
    UserDto save(UserRequestDto userRequestDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto updateById(Long id, UserRequestDto userRequestDto);

    void deleteById(Long id);
}
