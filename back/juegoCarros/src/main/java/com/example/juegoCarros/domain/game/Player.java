package com.example.juegoCarros.domain.game;

import com.example.juegoCarros.domain.helpers.Color;

public class Player {

    private String name;

    private Color color;

    private int points;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
