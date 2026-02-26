package com.cda.demo.dto;

import com.cda.demo.entity.Users;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class GameCreateDto {
    private String title;

    private String description;

    private Date publishAt;

    private ManufacturerCreateDto manufacturer;

    private List<CategoryCreateDto> categories = new ArrayList<>();

    private Users users;
}
