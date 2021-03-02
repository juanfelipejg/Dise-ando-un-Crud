package com.example.juegoCarros.controllers;

import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping(value = "api/game")
    public GameModel save (@Valid @RequestBody GameModel gameModel){
        return gameService.save(gameModel);
    }

}
