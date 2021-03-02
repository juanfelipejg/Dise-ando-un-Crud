package com.example.juegoCarros.entities;


import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer distance;

    @OneToMany
    private Players firstPlace;

    @OneToMany
    private Players secondPlace;

    @OneToMany
    private Players thirdPlace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Players getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(Players firstPlace) {
        this.firstPlace = firstPlace;
    }

    public Players getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(Players secondPlace) {
        this.secondPlace = secondPlace;
    }

    public Players getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(Players thirdPlace) {
        this.thirdPlace = thirdPlace;
    }
}
