package com.example.soccermanagerapi.api.controllers;

import com.example.soccermanagerapi.business.abstracts.PlayerService;
import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.entities.concretes.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerControllers {
    private PlayerService playerService;

    @Autowired
    public PlayerControllers(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Player>> getAll(){
        return this.playerService.getAll();
    }

    @PostMapping("/getByNameAndSurname")
    public DataResult<Player> getByNameAndSurname(@RequestParam String name, @RequestParam String surname){
        return this.playerService.getByNameAndSurname(name, surname);
    }

}
