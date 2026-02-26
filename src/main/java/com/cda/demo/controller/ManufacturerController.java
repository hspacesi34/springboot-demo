package com.cda.demo.controller;

import com.cda.demo.dto.*;
import com.cda.demo.entity.Manufacturer;
import com.cda.demo.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ManufacturerController extends AbstractController<ManufacturerCreateDto, ManufacturerUpdateDto, ManufacturerReadDto> {
    private final ManufacturerService manufacturerService;

    @PostMapping("/manufacturer")
    @ResponseStatus(HttpStatus.CREATED)
    public ManufacturerReadDto create(@RequestBody ManufacturerCreateDto manufacturerCreateDto) {
        Manufacturer manufacturer = modelMapper.map(manufacturerCreateDto, Manufacturer.class);
        Manufacturer manufacturerCreated = manufacturerService.create(manufacturer);
        ManufacturerReadDto manufacturerReadDto = modelMapper.map(manufacturerCreated, ManufacturerReadDto.class);
        return manufacturerReadDto;
    }

    @GetMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerReadDto findById(@PathVariable Integer id) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        return modelMapper.map(manufacturer, ManufacturerReadDto.class);
    }

    @GetMapping("/manufacturers")
    @ResponseStatus(HttpStatus.OK)
    public List<ManufacturerReadDto> findAll() {
        List<ManufacturerReadDto> manufacturerReadDtos = new ArrayList<>();
        for (Manufacturer manufacturer : this.manufacturerService.findAll()) {
            manufacturerReadDtos.add(modelMapper.map(manufacturer, ManufacturerReadDto.class));
        }
        return manufacturerReadDtos;
    }

    @DeleteMapping("/manufacturer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> delete(@PathVariable Integer id) {
        this.manufacturerService.delete(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","Manufacturer deleted");
        return map;
    }

    @PutMapping("/manufacturer")
    @ResponseStatus(HttpStatus.OK)
    public ManufacturerReadDto update(@RequestBody ManufacturerUpdateDto manufacturerUpdateDto) {
        Manufacturer manufacturer = modelMapper.map(manufacturerUpdateDto, Manufacturer.class);
        Manufacturer manufacturerUpdated = manufacturerService.update(manufacturer);
        return modelMapper.map(manufacturerUpdated, ManufacturerReadDto.class);
    }
}
