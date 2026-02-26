package com.cda.demo.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class ManufacturerReadDto {
    private Integer id;
    private String name;
    private String console;
}
