package com.example.juegoCarros.assembler;

import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.models.PlayerModel;

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

    public static PlayerModel makePlayerModel (Player player){
        PlayerModel playerModel = new PlayerModel();

        playerModel.setId(player.getId());
        playerModel.setName(player.getName());

        return playerModel;
    }

    public static Player makePlayer (PlayerModel playerModel){
        Player player = new Player();
        
        player.setId(playerModel.getId());
        player.setName(playerModel.getName());
        
        return player;
    }
}
