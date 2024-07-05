package com.dragand.ghc_api.web;


import com.dragand.ghc_api.entity.Game;
import com.dragand.ghc_api.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/game")
public class GameController {

    GameService gameService;

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        return new ResponseEntity<>(gameService.createGame(game), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Game>> getGames() {
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable Long id) {
        return new ResponseEntity<>(gameService.deleteGameById(id), HttpStatus.OK);
    }

}
