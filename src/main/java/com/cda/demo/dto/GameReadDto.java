package com.cda.demo.dto;

import com.cda.demo.entity.Users;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class GameReadDto {
    private Integer id;

    private String title;

    private String description;

    private Date publishAt;

    private ManufacturerReadDto manufacturer;

    private List<CategoryReadDto> categories = new ArrayList<>();
}
