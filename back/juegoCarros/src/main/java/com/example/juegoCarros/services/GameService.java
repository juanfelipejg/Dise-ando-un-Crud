package com.example.juegoCarros.services;

import com.example.juegoCarros.assembler.Assembler;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayersRepository playersRepository;

    public Player get (Integer id){
        return playersRepository.findById(id).orElseThrow();
    }

    public GameModel save (GameModel gameModel){
        Game game = Assembler.makeGame(gameModel);
        Game newGame = gameRepository.save(game);
        return Assembler.makeGameModel(newGame);
    }
}
