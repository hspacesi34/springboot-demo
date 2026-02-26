package com.cda.demo.dto;

import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class GameUpdateDto {
    private Integer id;

    private String title;

    private String description;

    private Date publishAt;

    private ManufacturerReadDto manufacturer;

    private List<CategoryReadDto> categories = new ArrayList<>();
}
