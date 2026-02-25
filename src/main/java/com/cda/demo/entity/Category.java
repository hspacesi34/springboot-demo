package com.cda.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Category extends BaseEntity {
    @Column(length =  50, nullable = false, unique = true)
    private String name;

}
