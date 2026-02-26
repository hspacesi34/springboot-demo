package com.cda.demo.controller;

import com.cda.demo.dto.GameCreateDto;
import com.cda.demo.dto.GameReadDto;
import com.cda.demo.dto.GameUpdateDto;
import com.cda.demo.entity.Game;
import com.cda.demo.service.GameService;
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
public class GameController extends AbstractController<GameCreateDto, GameUpdateDto, GameReadDto> {
    private final GameService gameService;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public GameReadDto create(@RequestBody GameCreateDto gameCreateDto) {
        Game game = modelMapper.map(gameCreateDto, Game.class);
        Game gameSaved = gameService.create(game);
        return modelMapper.map(gameSaved, GameReadDto.class);
    }

    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameReadDto findById(@PathVariable Integer id) {
        Game game = gameService.findById(id);
        return modelMapper.map(game, GameReadDto.class);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<GameReadDto> findAll() {
        List<GameReadDto> gameDtos = new ArrayList<>();
        for (Game game : this.gameService.findAll()) {
            gameDtos.add(modelMapper.map(game, GameReadDto.class));
        }
        return gameDtos;
    }

    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> delete(@PathVariable Integer id) {
        this.gameService.delete(id);
        Map<String,String> map = new HashMap<>();
        map.put("message","Game deleted");
        return map;
    }

    @PutMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public GameReadDto update(@RequestBody GameUpdateDto gameUpdateDto) {
        Game game = modelMapper.map(gameUpdateDto, Game.class);
        Game gameSaved = gameService.update(game);
        return modelMapper.map(gameSaved, GameReadDto.class);
    }
}
