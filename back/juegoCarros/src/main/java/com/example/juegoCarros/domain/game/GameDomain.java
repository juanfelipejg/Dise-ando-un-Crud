package com.example.juegoCarros.domain.game;

import com.example.juegoCarros.domain.game.values.Pist;
import com.example.juegoCarros.domain.game.values.PodiumDomain;
import com.example.juegoCarros.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class GameDomain {

    private Map<Integer, Player> players = new HashMap<Integer, Player>();

    private Pist pist;

    private boolean playing;

    private PodiumDomain podiumDomain;

    public void createPlayer(Player player){
        players.put(player.getId(), player);
    }

    public Map<Integer, Player> players() {
        return this.players;
    }

    public Pist getPist() {
        return pist;
    }

    public void setPist(Pist pist) {
        this.pist = pist;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void setFirstPlace(Player player){
        podiumDomain.setFirstPlace(player);
    }

    public void setSecondPlace(Player player){
     podiumDomain.setSecondPlace(player);
    }

    public void setThirdPlace(Player player){
         podiumDomain.setThirdPlace(player);
    }

    public void startGame(){
        this.playing = true;
    }

    public PodiumDomain podium() {
        return podiumDomain;
    }

    public void setPodium(PodiumDomain podiumDomain) {
        this.podiumDomain = podiumDomain;
    }
}
