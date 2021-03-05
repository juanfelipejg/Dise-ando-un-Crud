package com.example.juegoCarros.services;

import com.example.juegoCarros.domain.car.Car;
import com.example.juegoCarros.domain.game.GameDomain;
import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.game.values.PodiumDomain;
import com.example.juegoCarros.domain.track.Track;
import com.example.juegoCarros.domain.track.values.Position;
import com.example.juegoCarros.entities.*;
import com.example.juegoCarros.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RunGameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PartialResultRepository partialResultRepository;

    @Autowired
    private PodiumRepository podiumRepository;

    @Autowired
    private ResultRepository resultRepository;

    private Game game;

    private Map<Integer, Track> tracks = new HashMap<>();

    private GameDomain gameDomain = new GameDomain();


    public void startGame(Integer id){

        initialConfiguration(id);

        runGame();

        persistData();

    }

    private void initialConfiguration(Integer id) {

        game = gameRepository.findById(id).orElseThrow();

        int kilometers = game.getDistance();

        int numTracks = game.getNumberOfPlayers();

        Pist pist = new Pist(kilometers, numTracks);

        PodiumDomain podium = new PodiumDomain();

        gameDomain.setPist(pist);

        gameDomain.setPodium(podium);

        List<PartialResult> partialResultList = partialResultRepository.findAllByGame(game);

        for (PartialResult partialResult : partialResultList) {

            gameDomain.createPlayer(partialResult.getPlayer());
        }
        setTracks();

    }

    private void setTracks() {

        for (Map.Entry<Integer, Player> player : gameDomain.players().entrySet()) {
            tracks.put(player.getKey(), configureTrack(player.getValue()));
        }
    }

    private Track configureTrack(Player player) {

        return new Track(configureCar(player), configurePosition());
    }

    private Car configureCar(Player player) {

        String color = partialResultRepository.findByPlayer(player).getColor();
        return new Car(player, gameDomain.getPist().getKilometers() * 1000, color);
    }

    private Position configurePosition() {

        return new Position(0, gameDomain.getPist().getKilometers() * 1000);

    }

   private void runGame() {
        gameDomain.startGame();

        while (gameDomain.isPlaying()) {
            playerTurn();
        }
    }

    private void playerTurn() {
        for (Map.Entry<Integer, Player> player : gameDomain.players().entrySet()) {

            Player playerInTurn = player.getValue();
            Track trackInTurn = tracks.get(playerInTurn.getId());

            if(trackInTurn.isFinalDisplacement()){
                continue;
            }

            throwDice(playerInTurn, trackInTurn);

            setPodium(playerInTurn, trackInTurn);

            tracks.replace(playerInTurn.getId(), trackInTurn);

            try{

                Thread.sleep(1000);

            }catch (InterruptedException ex){

                Thread.currentThread().interrupt();
            }
        }
    }

    private void throwDice(Player playerInTurn, Track trackInTurn) {
        int launch = playerInTurn.throwDice();

        trackInTurn.moveCar(launch * 100);

        PartialResult partialResult = partialResultRepository.findByPlayer(playerInTurn);

        partialResult.setPartialDistance(trackInTurn.actualPosition());

        partialResultRepository.save(partialResult);

        trackInTurn.reachGoal();

        tracks.replace(playerInTurn.getId(), trackInTurn);
    }

    private void setPodium(Player playerInTurn, Track trackInTurn) {
        if (trackInTurn.isFinalDisplacement()) {

            if (isPlaceTaken(gameDomain.podium().getFirstPlace())) {

                gameDomain.setFirstPlace(playerInTurn);

            } else if (isPlaceTaken(gameDomain.podium().getSecondPlace())) {

                gameDomain.setSecondPlace(playerInTurn);

            } else {

                gameDomain.setThirdPlace(playerInTurn);
                gameDomain.setPlaying(false);
            }

        }
    }

    private boolean isPlaceTaken(Player player) {
        if(player == null) {

            return true;
        }
            return false;
    }

    private void persistData(){

        persistPodium();
        persistGameResults();
    }

    private void persistPodium() {
        Podium podium = new Podium();

        podium.setGame(game);
        podium.setFirstPlace(gameDomain.podium().getFirstPlace());
        podium.setSecondPlace(gameDomain.podium().getSecondPlace());
        podium.setThirdPlace(gameDomain.podium().getThirdPlace());

        podiumRepository.save(podium);
    }


    private void persistGameResults() {

        persistFirstPlayerResults();

        persistSecondPlayerResults();

        persistThirdPlayerResults();
    }

    private void persistFirstPlayerResults() {

        Player firstPlace = gameDomain.podium().getFirstPlace();

        Result resultFirst = new Result();

        if(resultRepository.findByPlayer(firstPlace) == null){
            resultFirst.setPlayer(firstPlace);
            resultFirst.setFirstPlaces(1);
        }
        else{
            resultFirst = resultRepository.findByPlayer(firstPlace);
            resultFirst.setFirstPlaces(resultFirst.getFirstPlaces() + 1);
        }

        resultRepository.save(resultFirst);

    }

    private void persistThirdPlayerResults() {

        Player secondPlace = gameDomain.podium().getSecondPlace();

        Result resultSecond = new Result();

        if (resultRepository.findByPlayer(secondPlace) == null){
            resultSecond.setPlayer(secondPlace);
            resultSecond.setSecondPlaces(1);
        }
        else{
            resultSecond = resultRepository.findByPlayer(secondPlace);
            resultSecond.setSecondPlaces(resultSecond.getThirdPlaces() + 1);
        }

        resultRepository.save(resultSecond);
    }

    private void persistSecondPlayerResults() {

        Player thirdPlace = gameDomain.podium().getThirdPlace();

        Result resultThird = new Result();

        if (resultRepository.findByPlayer(thirdPlace) == null){
            resultThird.setPlayer(thirdPlace);
            resultThird.setThirdPlaces(1);
        }
        else{
            resultThird = resultRepository.findByPlayer(thirdPlace);
            resultThird.setThirdPlaces(resultThird.getThirdPlaces() + 1);
        }

        resultRepository.save(resultThird);

    }



}