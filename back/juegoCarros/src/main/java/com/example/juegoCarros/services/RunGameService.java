package com.example.juegoCarros.services;

import com.example.juegoCarros.domain.game.GameDomain;
import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.track.Track;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PartialResultRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PartialResultRepository partialResultRepository;

    private Game game;

    private List<Track> track;

    private GameDomain gameDomain;


    private void configureGame (Integer id) {

        game = gameRepository.findById(id).orElseThrow();

        int kilometers = game.getDistance();

        int numTracks = game.getNumberOfPlayers();

        Pist pist = new Pist(kilometers, numTracks);

        gameDomain.setPist(pist);

        List<PartialResult> partialResultList = partialResultRepository.findAllByGame(game);

        for(PartialResult partialResult: partialResultList){

            gameDomain.createPlayer(partialResult.getPlayer());
        }

    }
}
