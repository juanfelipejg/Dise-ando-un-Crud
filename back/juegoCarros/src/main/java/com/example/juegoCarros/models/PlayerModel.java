package com.example.juegoCarros.models;

public class PlayerModel {

    private Integer id;

    private String name;

    private String color;

    private Integer gameId;

    private int partialDistance;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color; }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public int getPartialDistance() {
        return partialDistance;
    }

    public void setPartialDistance(int partialDistance) {
        this.partialDistance = partialDistance;
    }
}
