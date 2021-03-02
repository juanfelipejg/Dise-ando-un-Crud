package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayersRepository extends CrudRepository<Player, Integer> {
}
