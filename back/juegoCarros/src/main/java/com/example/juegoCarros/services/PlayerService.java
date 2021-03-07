package com.example.juegoCarros.services;


import com.example.juegoCarros.assembler.Assembler;
import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.PartialResultModel;
import com.example.juegoCarros.models.PlayerModel;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PartialResultRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PartialResultRepository partialResultRepository;

    @Autowired
    private GameRepository gameRepository;

    public Iterable<PlayerModel> list() {

        Iterable<Player> players = playerRepository.findAll();
        List<PlayerModel> playerModelList = new ArrayList<>();
        for(Player player: players){
            playerModelList.add(Assembler.makePlayerModel(player));
        }

        return playerModelList;
    }

    public PlayerModel save (PlayerModel playerModel){

        Player player = Assembler.makePlayer(playerModel);
        playerRepository.save(player);

        PartialResultModel partialResultModel = Assembler.makePartialResultModel(playerModel);
        PartialResult partialResult = Assembler.makePartialResult(partialResultModel);
        partialResult.setPlayer(get(player.getId()));
        partialResult.setGame(gameRepository.findById(playerModel.getGameId()).orElseThrow());

        partialResultRepository.save(partialResult);

        PlayerModel playerModelReturn = Assembler.makePlayerModel(playerRepository.save(player));
        playerModelReturn.setColor(playerModel.getColor());
        playerModelReturn.setGameId(playerModel.getGameId());

        return playerModelReturn;
    }

    public Player get(Integer id) {
        return playerRepository.findById(id).orElseThrow();
    }

    public PlayerModel getPlayerModel(Integer id){
        Player player = get(id);
        return Assembler.makePlayerModel(player);
    }

}
