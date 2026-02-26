package com.cda.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UsersCreateDto {
    @NotBlank
    @Length(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Length(min = 2, max = 50)
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 2, max = 100)
    private String password;
}
