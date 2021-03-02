package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
