package com.example.juegoCarros.entities;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.*;
import java.util.Set;

public class PartialResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Players player;

    @OneToOne
    private Game game;

    private int partialDistance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPartialDistance() {
        return partialDistance;
    }

    public void setPartialDistance(int partialDistance) {
        this.partialDistance = partialDistance;
    }
}
