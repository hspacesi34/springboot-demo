package com.cda.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length =  50, nullable = false, unique = true)
    @NotBlank
    @Length(min = 3, max = 50)
    private String name;
    @Column(length =  50, unique = true)
    @Length(min = 3, max = 50)
    private String console;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.REMOVE)
    private List<Game> games = new ArrayList<>();
}
