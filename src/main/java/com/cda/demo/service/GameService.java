package com.cda.demo.service;

import com.cda.demo.entity.Game;
import com.cda.demo.exception.ResourceNotFoundException;
import com.cda.demo.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService extends AbstractService<Game> {
    private GameRepository gameRepository;

    @Override
    public Game findById(Integer id) {
        return this.gameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Game.class));
    }

    @Override
    public Iterable<Game> findAll() {
        Iterable<Game> games = this.gameRepository.findAll();
        if (!games.iterator().hasNext()) {
            throw new ResourceNotFoundException(Game.class);
        }
        return games;
    }

    @Override
    public void delete(Integer id) {
        if (this.gameRepository.existsById(id)) {
            this.gameRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Game.class);
        }
    }

    @Override
    public Game create(Game entity) {
        Game game = this.gameRepository.save(entity);
        return game;
    }

    @Override
    public Game update(Game entity) {
        if (this.gameRepository.existsById(entity.getId())) {
            return this.gameRepository.save(entity);
        }
        throw new ResourceNotFoundException(Game.class);
    }

    @Override
    public boolean exists(Integer id) {
        boolean exists = this.gameRepository.existsById(id);
        return exists;
    }
}
