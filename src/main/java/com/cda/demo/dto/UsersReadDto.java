package com.cda.demo.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class UsersReadDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<GameReadDto> games = new ArrayList<>();
}
