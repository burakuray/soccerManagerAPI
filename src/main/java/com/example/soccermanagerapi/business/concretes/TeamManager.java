package com.example.soccermanagerapi.business.concretes;

import com.example.soccermanagerapi.business.abstracts.PlayerService;
import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.SuccessDataResult;
import com.example.soccermanagerapi.dataAccess.abstracts.PlayerDao;
import com.example.soccermanagerapi.entities.concretes.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamManager implements PlayerService {

    private PlayerDao playerDao;

    @Autowired
    public TeamManager(PlayerDao playerDao){
        super();
        this.playerDao = playerDao;
    }

    @Override
    public DataResult<List<Player>> getAll() {
        return new SuccessDataResult<List<Player>>(this.playerDao.findAll(),"Players listed");
    }

    @Override
    public DataResult<Player> getByNameAndSurname(String name, String surname) {
        return new SuccessDataResult<Player>(this.playerDao.getByNameAndSurname(name,surname),"Players listed by name and surname");
    }
}
