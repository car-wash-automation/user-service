package org.example.userservice.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.UserDto;
import org.example.userservice.dto.UserRequestDto;
import org.example.userservice.mapper.UserMapper;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserRequestDto userRequestDto) {
        User user = userMapper.toModel(userRequestDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id).stream()
                .map(userMapper::toDto)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Can not find user with id: " + id));
    }

    @Override
    public UserDto updateById(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("User with id: " + id + " does not exist"));
        userMapper.updateUserFromDto(userRequestDto, user);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
