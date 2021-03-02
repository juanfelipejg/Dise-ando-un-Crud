package com.example.juegoCarros.assembler;

import com.example.juegoCarros.entities.Game;

import com.example.juegoCarros.entities.Podium;
import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.models.PodiumModel;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.PlayerModel;


public class Assembler {

    @Autowired
    PlayerRepository playerRepository;

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


    public static Podium makePodium(PodiumModel podiumModel){

        Podium podium = new Podium();
        podium.setId(podiumModel.getId());

        return podium;
    }

    public static PodiumModel makePodiumModel(Podium podium) {
        PodiumModel podiumModel = new PodiumModel();

        podiumModel.setId(podium.getId());
        podiumModel.setFirstPlayerId(podium.getFirstPlace().getId());
        podiumModel.setSecondPlayerId(podium.getSecondPlace().getId());
        podiumModel.setThirdPlayerId(podium.getThirdPlace().getId());
        podiumModel.setGameId(podium.getGame().getId());

        return podiumModel;
    }

    public static PlayerModel makePlayerModel(Player player){
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
