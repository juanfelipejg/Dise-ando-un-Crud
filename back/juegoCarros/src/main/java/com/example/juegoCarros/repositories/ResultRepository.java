package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.entities.Result;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Integer> {
    public Result findByPlayer(Player player);
}
