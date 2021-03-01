package com.example.juegoCarros.domain.car;

import com.example.juegoCarros.domain.game.Player;
import com.example.juegoCarros.domain.helpers.Color;
import com.example.juegoCarros.domain.game.Player;
public class Car {

    private Player driver;
    private int distance;
    private Color color;

    public Car(Player driver, int distance, Color color){
        this.driver = driver;
        this.distance = distance;
        this.color  = color;
    }

    public void setDriver(Player driver){
        this.driver = driver;
    }

    public void moveOnTrack(int distance){
        this.distance += distance;
    }

    public Player driver(){
        return this.driver;
    }

    public int distance(){
        return this.distance;
    }

    public String color(){
        return this.color.getColor();
    }
}
