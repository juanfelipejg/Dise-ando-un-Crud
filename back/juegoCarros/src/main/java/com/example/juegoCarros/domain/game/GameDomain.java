package com.example.juegoCarros.domain.game;

import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.game.values.Podium;
import com.example.juegoCarros.domain.helpers.Color;
import com.example.juegoCarros.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class GameDomain {

    private Map<Integer, Player> players = new HashMap<Integer, Player>();
    private Pist pist;
    private boolean playing;
    private Podium podium;

    public void createPlayer(Player player){
        players.put(player.getId(), player);
    }

    public Pist getPist() {
        return pist;
    }

    public void setPist(Pist pist) {
        this.pist = pist;
    }

    public void setFirstPlace(Player player){
        podium.setFirstPlace(player);
    }

    public void setSecondPlace(Player player){
     podium.setSecondPlace(player);
    }

    public void thirdSecondPlace(Player player){
         podium.setThirdPlace(player);
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
