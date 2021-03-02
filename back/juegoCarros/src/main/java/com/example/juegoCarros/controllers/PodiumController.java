package com.example.juegoCarros.controllers;

import com.example.juegoCarros.models.PodiumModel;
import com.example.juegoCarros.services.PodiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PodiumController {

    @Autowired
    PodiumService podiumService;

    @GetMapping("api/{id}/podium")
    public PodiumModel get(@PathVariable("id") Integer id){
        return podiumService.get(id);
    }

    @PostMapping("api/podium")
    public PodiumModel save(PodiumModel podiumModel){
        return podiumService.save(podiumModel);
    }


}
