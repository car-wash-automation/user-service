package org.example.userservice.mapper;

import org.example.userservice.config.MapperConfig;
import org.example.userservice.dto.UserDto;
import org.example.userservice.dto.UserRequestDto;
import org.example.userservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(config = MapperConfig.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper { //target - return type(userDto), source - user
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "sex", source = "sex")
    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "sex", source = "sex")
    @Mapping(target = "role", source = "role")
    User toModel(UserRequestDto requestDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "sex", source = "sex")
    @Mapping(target = "role", source = "role")
    void updateUserFromDto(UserRequestDto userRequestDto, @MappingTarget User user);
}
