package com.example.soccermanagerapi.business.abstracts;

import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.entities.concretes.Player;

import java.util.List;

public interface PlayerService {
    DataResult<List<Player>> getAll();
    DataResult<Player> getByNameAndSurname(String name, String surname);
}
