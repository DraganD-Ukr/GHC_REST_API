package com.dragand.ghc_api.service;

import com.dragand.ghc_api.entity.Game;
import com.dragand.ghc_api.exception.EntityNotFoundException;
import com.dragand.ghc_api.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {

    GameRepository gameRepository;


    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return unwrapGame(game, id);
    }

    public Game unwrapGame(Optional<Game> game, Long id) {
        if (game.isPresent()) {
            return game.get();
        } else {
            throw new EntityNotFoundException(id, Game.class);
        }
    }

    public Game deleteGameById(Long id) {
        Game deleted = unwrapGame(gameRepository.findById(id), id); //Store the game to be deleted to return.
        gameRepository.deleteById(id);
        return deleted;
    }
}
