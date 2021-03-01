package com.example.juegoCarros.domain.game;

import com.example.juegoCarros.domain.game.values.Name;
import com.example.juegoCarros.domain.helpers.Color;

public class Player {

    private Name name;

    private Color color;

    private int points;

    public Player(Name name, Color color) {
        this.name = name;
        this.color = color;
        this.points = 0;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
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
