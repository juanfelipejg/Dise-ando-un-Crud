package com.example.juegoCarros.entities;

import javax.persistence.*;

@Entity
public class Podium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Player firstPlace;

    @OneToOne
    private Player secondPlace;

    @OneToOne
    private Player thirdPlace;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
