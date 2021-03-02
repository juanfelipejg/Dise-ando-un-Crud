package com.example.juegoCarros.repositories;


import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.Podium;
import org.springframework.data.repository.CrudRepository;

public interface PodiumRepository extends CrudRepository<Podium, Integer> {

    public Podium findByGame(Game game);
}
