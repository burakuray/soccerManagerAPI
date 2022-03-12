package com.example.soccermanagerapi.business.abstracts;

import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.Result;
import com.example.soccermanagerapi.core.utilities.results.SuccessResult;
import com.example.soccermanagerapi.entities.concretes.Player;
import com.example.soccermanagerapi.entities.concretes.Team;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface TeamService {
    DataResult<List<Team>> getAll();
    DataResult<Team> getByTeamTotalValue(String name);
    Result createTeam(Team team);
    Result updateTeamName(String newTeamName);
    Result deleteTeam(Integer teamId);
    DataResult<Team> getByName(String name);
}