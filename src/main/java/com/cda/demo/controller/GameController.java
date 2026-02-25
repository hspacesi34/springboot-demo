package com.cda.demo.controller;

import com.cda.demo.entity.Game;
import com.cda.demo.entity.Manufacturer;
import com.cda.demo.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GameController {
    private GameService gameService;

    @PostMapping("/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game) throws URISyntaxException {
        return this.gameService.create(game);
    }
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game findById(@PathVariable Integer id) {
        return this.gameService.findById(id);
    }
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Game> findAll() {
        return this.gameService.findAll();
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
    public Game update(@RequestBody Game game) {
        return gameService.update(game);
    }
}
