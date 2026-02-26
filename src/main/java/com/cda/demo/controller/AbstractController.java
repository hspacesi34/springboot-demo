package com.cda.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public abstract class AbstractController<CreateDto, UpdateDto, ReadDto> {
    @Autowired
    protected ModelMapper modelMapper;

    public abstract ReadDto create(@RequestBody CreateDto createDto);
    public abstract ReadDto update(@RequestBody UpdateDto updateDto);
    public abstract Map<String, String> delete(@PathVariable Integer id);
    public abstract List<ReadDto> findAll();
    public abstract ReadDto findById(@PathVariable Integer id);
}
