package com.example.juegoCarros.assembler;

import com.example.juegoCarros.entities.Game;

import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Podium;
import com.example.juegoCarros.entities.Result;
import com.example.juegoCarros.models.GameModel;
import com.example.juegoCarros.models.PartialResultModel;
import com.example.juegoCarros.models.PodiumModel;
import com.example.juegoCarros.models.ResultModel;
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


    public static PartialResultModel makePartialResultModel(PartialResult partialResult){
        PartialResultModel partialResultModel= new PartialResultModel();

        partialResultModel.setId(partialResult.getId());
        partialResultModel.setGameId(partialResult.getGame().getId());
        partialResultModel.setPartialDistance(partialResult.getPartialDistance());
        partialResultModel.setPlayerId(partialResult.getPlayer().getId());

        return partialResultModel;
    }

    public static PartialResult makePartialResult(PartialResultModel partialResultModel) {

        PartialResult partialResult = new PartialResult();

        partialResult.setId(partialResultModel.getId());
        partialResult.setPartialDistance(partialResultModel.getPartialDistance());

        return partialResult;
    }

    public static ResultModel makeResultModel (Result result){
        ResultModel resultModel = new ResultModel();

        resultModel.setId(result.getId());
        resultModel.setPlayerId(result.getPlayer().getId());
        resultModel.setFirstPlaces(result.getFirstPlaces());
        resultModel.setSecondPlaces(result.getSecondPlaces());
        resultModel.setThirdPlaces(result.getThirdPlaces());

        return  resultModel;
    }

    public static Result makeResult (ResultModel resultModel){
        Result result = new Result();

        result.setId(resultModel.getId());
        result.setFirstPlaces(resultModel.getFirstPlaces());
        result.setSecondPlaces(resultModel.getSecondPlaces());
        result.setThirdPlaces(resultModel.getThirdPlaces());

        return result;

    }
}
