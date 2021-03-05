package com.example.juegoCarros.services;


import com.example.juegoCarros.assembler.Assembler;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.models.PartialResultModel;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PartialResultRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartialResultService {

    @Autowired
    PartialResultRepository partialResultRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    public PartialResultModel get(Integer id){
        return Assembler.makePartialResultModel(partialResultRepository.findById(id).orElseThrow());
    }

    public PartialResultModel save(PartialResultModel partialResultModel){

        PartialResult partialResult = Assembler.makePartialResult(partialResultModel);
        partialResult.setGame(gameRepository.findById(partialResultModel.getGameId()).orElseThrow());
        partialResult.setPlayer(playerRepository.findById(partialResultModel.getPlayerId()).orElseThrow());

        return Assembler.makePartialResultModel(partialResultRepository.save(partialResult));
    }

    public void delete(Integer id){

        PartialResult partialResult = Assembler.makePartialResult(get(id));
        partialResultRepository.delete(partialResult);
    }

    public Iterable<PartialResultModel> getByGame(Integer id){

        Game game = gameRepository.findById(id).orElseThrow();

        Iterable<PartialResult> partialResults = partialResultRepository.findAllByGame(game);
        List<PartialResultModel> partialResultsModel = new ArrayList<>();

        for(PartialResult result : partialResults){
            partialResultsModel.add(Assembler.makePartialResultModel(result));
        }

        return partialResultsModel;
    }




}
