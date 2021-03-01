package com.example.juegoCarros.domain.game;

import com.example.juegoCarros.domain.game.values.Name;
import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.game.values.Podium;
import com.example.juegoCarros.domain.helpers.Color;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<Integer, Player> players = new HashMap<Integer, Player>();
    private Pist pist;
    private boolean playing;
    private Podium podium;

    public void createPlayer(Integer playerID, Name name, Color color ){
        Player player = new Player(name, color);
        players.put(playerID, player);
    }

    public void setFirstPlace(Integer playerID){
        podium.setFirstPlace(players.get(playerID));
    }

    public void setSecondPlace(Integer playerID){
     podium.setSecondPlace(players.get(playerID));
    }

    public void thirdSecondPlace(Integer playerID){
         podium.setThirdPlace(players.get(playerID));
    }

    public void startGame(){
        this.playing = true;
    }

    public Map<Integer, Player> players() {
        return this.players;
    }

    public Pist pist() {
        return pist;
    }

    public boolean isPlaying() {
        return playing;
    }

    public Podium podium() {
        return podium;
    }

}
