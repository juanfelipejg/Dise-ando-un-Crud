package com.example.juegoCarros.domain.track.values;

public class Position {
    int actual;
    int goal;

    public Position(int actual, int goal){
        this.actual = actual;
        this.goal = goal;
    }

    public int getActual() {
        return actual;
    }

    public void changeActualPosition(int meters) {
        this.actual += meters;
    }

    public int getGoal() {
        return goal;
    }
}
