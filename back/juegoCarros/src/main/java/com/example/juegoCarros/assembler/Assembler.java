package com.example.juegoCarros.assembler;

import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.models.GameModel;

public class Assembler {

    public static Game makeGame (GameModel gameModel){
        Game game = new Game();
        game.setId(gameModel.getId());
        game.setNumberOfPlayers(gameModel.getNumberOfPlayers());
        game.setDistance(gameModel.getDistance());

        return game;
    }

    public static GameModel makeGameModel (Game game){
        GameModel gameModel = new GameModel();

        gameModel.setId(game.getId());
        gameModel.setNumberOfPlayers(game.getNumberOfPlayers());
        gameModel.setDistance(game.getDistance());
        
        return gameModel;
    }
}
