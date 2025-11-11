package org.example.userservice.dto;

import lombok.Data;
import org.example.userservice.model.Sex;
import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private Sex sex;
}
