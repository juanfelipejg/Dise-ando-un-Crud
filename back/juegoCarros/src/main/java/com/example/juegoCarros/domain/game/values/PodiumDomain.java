package com.example.juegoCarros.domain.game.values;

import com.example.juegoCarros.entities.Player;

public class PodiumDomain {

    private Player firstPlace;

    private Player secondPlace;

    private Player thirdPlace;

    public Player getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(Player firstPlace) {
        this.firstPlace = firstPlace;
    }

    public Player getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(Player secondPlace) {
        this.secondPlace = secondPlace;
    }

    public Player getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(Player thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public boolean isFill(){
        return true;
    }
}
