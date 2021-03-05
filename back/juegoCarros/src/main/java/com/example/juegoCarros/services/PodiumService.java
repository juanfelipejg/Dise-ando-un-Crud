package com.example.juegoCarros.services;

import com.example.juegoCarros.assembler.Assembler;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.Podium;
import com.example.juegoCarros.models.PodiumModel;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import com.example.juegoCarros.repositories.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PodiumService {

    @Autowired
    PodiumRepository podiumRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    public PodiumModel save(PodiumModel podiumModel){

        Podium podium = Assembler.makePodium(podiumModel);

        podium.setFirstPlace(playerRepository.findById(podiumModel.getFirstPlayerId()).orElseThrow());
        podium.setSecondPlace(playerRepository.findById(podiumModel.getSecondPlayerId()).orElseThrow());
        podium.setThirdPlace(playerRepository.findById(podiumModel.getThirdPlayerId()).orElseThrow());
        podium.setGame(gameRepository.findById(podiumModel.getGameId()).orElseThrow());

        return Assembler.makePodiumModel(podiumRepository.save(podium));

    }

    public PodiumModel get(Integer id){
        Podium podium = podiumRepository.findById(id).orElseThrow(() ->
                new RuntimeException("There is not Podium with the id provided"));

        return Assembler.makePodiumModel(podium);

    }

    public PodiumModel getByGame(Integer id){
        Game game = gameRepository.findById(id).orElseThrow();
        return Assembler.makePodiumModel(podiumRepository.findByGame(game));
    }

}
