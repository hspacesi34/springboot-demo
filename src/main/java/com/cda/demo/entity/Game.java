package com.cda.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Game implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length =  50, nullable = false)
    private String title;
    @Column(length =  255)
    private String description;
    @Column(nullable = false, name = "publish_at")
    private Date publishAt;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToMany
    @JoinTable(name = "game_category", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private ArrayList<Category> categories = new ArrayList<>();
}
