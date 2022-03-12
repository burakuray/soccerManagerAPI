package com.example.soccermanagerapi.dataAccess.abstracts;

import com.example.soccermanagerapi.entities.concretes.Player;
import com.example.soccermanagerapi.entities.concretes.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {
    @Query("From Team where name =: name")
    Player getByName(String name);

    @Query("From Team order by team_total_value desc")
    Player getByTeamTotalValueOrderByDesc();
}