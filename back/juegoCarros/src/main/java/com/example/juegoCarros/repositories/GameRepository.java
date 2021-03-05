package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
