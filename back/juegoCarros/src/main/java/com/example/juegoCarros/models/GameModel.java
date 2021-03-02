package com.example.juegoCarros.models;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

public class GameModel {
    
    
    private Integer id;

    @NotNull
    @Min(3)
    private Integer numberOfPlayers;
    
    @NotNull
    @Positive
    private int distance;
    
    private Integer firstPlaceId;
    
    private Integer secondPlaceId;
    
    private Integer thirdPlaceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getFirstPlaceId() {
        return firstPlaceId;
    }

    public void setFirstPlaceId(Integer firstPlaceId) {
        this.firstPlaceId = firstPlaceId;
    }

    public Integer getSecondPlaceId() {
        return secondPlaceId;
    }

    public void setSecondPlaceId(Integer secondPlaceId) {
        this.secondPlaceId = secondPlaceId;
    }

    public Integer getThirdPlaceId() {
        return thirdPlaceId;
    }

    public void setThirdPlaceId(Integer thirdPlaceId) {
        this.thirdPlaceId = thirdPlaceId;
    }
}
