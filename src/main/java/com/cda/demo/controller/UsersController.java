package com.cda.demo.controller;

import com.cda.demo.dto.UsersCreateDto;
import com.cda.demo.dto.UsersReadDto;
import com.cda.demo.dto.UsersUpdateDto;
import com.cda.demo.entity.Users;
import com.cda.demo.service.UsersService;
import jakarta.validation.Valid;
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
public class UsersController extends AbstractController<UsersCreateDto, UsersUpdateDto, UsersReadDto> {
    private final UsersService usersService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public UsersReadDto create(@RequestBody UsersCreateDto usersCreateDto) {
        Users users = modelMapper.map(usersCreateDto, Users.class);
        Users userCreated = this.usersService.create(users);
        return modelMapper.map(userCreated, UsersReadDto.class);
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public UsersReadDto update(@RequestBody UsersUpdateDto usersUpdateDto) {
        Users users = modelMapper.map(usersUpdateDto, Users.class);
        Users usersUpdated = this.usersService.update(users);
        return modelMapper.map(usersUpdated, UsersReadDto.class);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Map<String, String> delete(Integer id) {
        this.usersService.delete(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","User deleted");
        return map;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<UsersReadDto> findAll() {
        List<UsersReadDto> usersReadDtos = new ArrayList<>();
        for (Users users : this.usersService.findAll()) {
            usersReadDtos.add(modelMapper.map(users, UsersReadDto.class));
        }
        return usersReadDtos;
    }

    @GetMapping("/user/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public UsersReadDto findById(@PathVariable Integer id) {
        Users users = this.usersService.findById(id);
        return modelMapper.map(users, UsersReadDto.class);
    }

    @GetMapping("/user/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UsersReadDto findByEmail(@PathVariable String email) {
        Users users = this.usersService.findByEmail(email);
        return modelMapper.map(users, UsersReadDto.class);
    }
}
