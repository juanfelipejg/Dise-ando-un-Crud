package com.example.juegoCarros.entities;



import org.springframework.lang.Nullable;
import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer distance;

    private Integer numberOfPlayers;

    @Nullable
    @OneToOne
    private Player firstPlace;

    @Nullable
    @OneToOne
    private Player secondPlace;

    @Nullable
    @OneToOne
    private Player thirdPlace;

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

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
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
