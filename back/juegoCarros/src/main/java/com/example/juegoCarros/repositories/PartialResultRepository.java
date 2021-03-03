package com.example.juegoCarros.repositories;

import com.example.juegoCarros.entities.Game;
import com.example.juegoCarros.entities.PartialResult;
import com.example.juegoCarros.entities.Player;
import com.example.juegoCarros.entities.Podium;
import com.example.juegoCarros.models.PartialResultModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartialResultRepository extends CrudRepository<PartialResult, Integer> {

    public List<PartialResult> findAllByGame(Game game);

    public PartialResult findByPlayer(Player player);
}
