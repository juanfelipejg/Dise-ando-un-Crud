package com.example.juegoCarros.services;

import com.example.juegoCarros.domain.car.Car;
import com.example.juegoCarros.domain.game.GameDomain;
import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.track.Track;
import com.example.juegoCarros.domain.track.values.Position;
import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.repositories.GameRepository;
import com.example.juegoCarros.repositories.PartialResultRepository;
import com.example.juegoCarros.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RunGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PartialResultRepository partialResultRepository;

    private Game game;

    private Map<Integer, Track> tracks;

    private GameDomain gameDomain;

    public void setTracks() {

        for (Map.Entry<Integer, Player> player : gameDomain.players().entrySet()) {
            tracks.put(player.getKey(), configureTrack(player.getValue()));
        }

    }

    private void initialConfiguration(Integer id) {

        game = gameRepository.findById(id).orElseThrow();

        int kilometers = game.getDistance();

        int numTracks = game.getNumberOfPlayers();

        Pist pist = new Pist(kilometers, numTracks);

        gameDomain.setPist(pist);

        List<PartialResult> partialResultList = partialResultRepository.findAllByGame(game);

        for (PartialResult partialResult : partialResultList) {

            gameDomain.createPlayer(partialResult.getPlayer());
        }

    }

    private Car configureCar(Player player) {

        String color = partialResultRepository.findByPlayer(player).getColor();
        return new Car(player, gameDomain.getPist().getKilometers() * 1000, color);
    }

    private Position configurePosition() {

        return new Position(0, gameDomain.getPist().getKilometers() * 1000);

    }

    private Track configureTrack(Player player) {

        return new Track(configureCar(player), configurePosition());

    }

    private void runGame() {

        gameDomain.setPlaying(true);

        while (gameDomain.isPlaying()) {

            for (Map.Entry<Integer, Player> player : gameDomain.players().entrySet()) {
                int launch = player.getValue().throwDice();

                tracks.get(player.getKey()).moveCar(launch * 100);
                PartialResult partialResult = partialResultRepository.findByPlayer(player.getValue());
                partialResult.setPartialDistance(tracks.get(player.getValue()).actualPosition());
                partialResultRepository.save(partialResult);

                tracks.get(player.getKey()).reachGoal();
                if (tracks.get(player.getKey()).isFinalDisplacement()) {
                    if (gameDomain.podium().getFirstPlace() == null) {
                        gameDomain.setFirstPlace(player.getValue());
                    } else if (gameDomain.podium().getSecondPlace() == null) {
                        gameDomain.setSecondPlace(player.getValue());
                    } else {
                        gameDomain.setThirdPlace(player.getValue());
                        gameDomain.setPlaying(false);
                    }

                }


            }


        }


    }
}