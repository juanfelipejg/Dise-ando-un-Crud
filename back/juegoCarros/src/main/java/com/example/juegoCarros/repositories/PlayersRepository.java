package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.Players;
import org.springframework.data.repository.CrudRepository;

public interface PlayersRepository extends CrudRepository<Players, Integer> {
}
