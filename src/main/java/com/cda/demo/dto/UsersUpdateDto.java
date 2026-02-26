package com.cda.demo.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UsersUpdateDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
