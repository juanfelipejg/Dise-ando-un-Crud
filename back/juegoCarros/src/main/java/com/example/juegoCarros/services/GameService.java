package com.example.juegoCarros.services;

import com.example.juegoCarros.assembler.Assembler;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.models.PlayerModel;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Player get (Integer id){
        return playerRepository.findById(id).orElseThrow();
    }

    public GameModel save (GameModel gameModel){
        Game game = Assembler.makeGame(gameModel);
        return Assembler.makeGameModel(gameRepository.save(game));
    }

    public Iterable<GameModel> list() {

        Iterable<Game> games = gameRepository.findAll();
        List<GameModel> gameModelList = new ArrayList<>();
        for(Game game: games){
            gameModelList.add(Assembler.makeGameModel(game));
        }

        return gameModelList;
    }


}
