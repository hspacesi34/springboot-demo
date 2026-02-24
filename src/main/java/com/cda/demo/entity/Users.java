package com.cda.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utilisateur")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Users implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(unique = true, nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
}
