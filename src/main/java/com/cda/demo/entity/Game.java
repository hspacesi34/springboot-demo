package com.cda.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Game extends BaseEntity {
    @Column(length =  50, nullable = false)
    @NotBlank
    @Length(min = 2, max = 50)
    private String title;
    @Column(length =  255)
    @NotBlank
    @Length(min = 5, max = 255)
    private String description;
    @Column(nullable = false, name = "publish_at")
    @NotNull(message = "La date de publication est obligatoire")
    @PastOrPresent(message = "La date ne peut pas être dans le futur")
    private LocalDate publishAt;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnoreProperties("games")
    @NotNull(message = "Doit possèder un manufacturer")
    private Manufacturer manufacturer;
    @ManyToMany
    @JoinTable(name = "game_category", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @NotEmpty(message = "Doit avoir au moins une catégorie")
    private List<Category> categories = new ArrayList<>();
}
