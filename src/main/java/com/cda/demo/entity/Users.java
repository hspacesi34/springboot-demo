package com.cda.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    @NotBlank
    @Length(min = 2, max = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    @NotBlank
    @Length(min = 2, max = 50)
    private String lastName;
    @Column(unique = true, nullable = false, length = 100)
    @NotBlank
    @Email
    private String email;
    @Column(nullable = false, length = 100)
    @NotBlank
    @Length(min = 2, max = 100)
    private String password;
    @OneToMany(mappedBy = "users")
    private List<Game> games = new ArrayList<>();
}
