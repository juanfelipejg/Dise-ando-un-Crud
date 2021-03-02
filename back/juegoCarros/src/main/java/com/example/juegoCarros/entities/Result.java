package com.example.juegoCarros.entities;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Player player;

    private Integer firstPlaces;

    private Integer secondPlaces;

    private Integer thirdPlaces;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getFirstPlaces() {
        return firstPlaces;
    }

    public void setFirstPlaces(Integer firstPlaces) {
        this.firstPlaces = firstPlaces;
    }

    public Integer getSecondPlaces() {
        return secondPlaces;
    }

    public void setSecondPlaces(Integer secondPlaces) {
        this.secondPlaces = secondPlaces;
    }

    public Integer getThirdPlaces() {
        return thirdPlaces;
    }

    public void setThirdPlaces(Integer thirdPlaces) {
        this.thirdPlaces = thirdPlaces;
    }
}
