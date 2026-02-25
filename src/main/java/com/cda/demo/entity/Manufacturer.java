package com.cda.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Manufacturer extends BaseEntity {
    @Column(length =  50, nullable = false, unique = true)
    @NotBlank
    @Length(min = 3, max = 50)
    private String name;
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("manufacturer")
    private List<Game> games = new ArrayList<>();
}
