package com.example.soccermanagerapi.api.controllers;

import com.example.soccermanagerapi.business.abstracts.TeamService;
import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.Result;
import com.example.soccermanagerapi.core.utilities.results.SuccessResult;
import com.example.soccermanagerapi.entities.concretes.Player;
import com.example.soccermanagerapi.entities.concretes.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamControllers {
    private TeamService teamService;

    @Autowired
    public TeamControllers(TeamService teamService){
        this.teamService = teamService;
    }

    @PostMapping("/createTeam")
    public Result createTeam(@RequestBody Team team){
        this.teamService.createTeam(team);
        return new SuccessResult("Team created.");
    }

    @PostMapping("/updateTeam")
    public Result updateTeamName(@RequestBody String newTeamName){
        this.teamService.updateTeamName(newTeamName);
        return new SuccessResult("Team updated.");
    }

    @DeleteMapping("/deleteTeam")
    public Result deleteTeam(@RequestBody Integer teamId){
        this.teamService.deleteTeam(teamId);
        return new SuccessResult("Team" + teamId+ " deleted.");
    }

    @GetMapping("/getall")
    public DataResult<List<Team>> getAll(){
        return this.teamService.getAll();
    }

    @PostMapping("/getByName")
    public DataResult<Team> getByNameAndSurname(@RequestParam String name){
        return this.teamService.getByName(name);
    }
}
