package com.example.juegoCarros.domain.track;

import com.example.juegoCarros.domain.car.Car;
import com.example.juegoCarros.domain.track.values.Position;

public class Track {
    private Car car;
    private Position position;
    private int meters;
    private boolean finalDisplacement;


    public Track(Car car, Position position, int meters){
        this.car = car;
        this.position = position;
        this.meters = position.getActual();
        this.finalDisplacement = false;
    }

    public void addCar(Car car){
        this.car = car;
    }

    public void reachGoal(){
        if(actualPosition() >= desiredPosition()){

            this.finalDisplacement = true;
        }
        else{
            
            this.finalDisplacement = false;
        }
    }

    public void moveCar(){
        this.position.changeActualPosition(meters);
        this.car.moveOnTrack(meters);
    }

    public int meters(){
        return this.meters;
    }

    public int actualPosition(){
        return this.position.getActual();
    }

    public int desiredPosition(){
        return this.position.getGoal();
    }

    boolean isFinalDisplacement(){
        return finalDisplacement;
    }
}
