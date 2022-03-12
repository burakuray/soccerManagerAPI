package com.example.soccermanagerapi.dataAccess.abstracts;

import com.example.soccermanagerapi.entities.concretes.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao extends JpaRepository<Player,Integer> {
    @Query("From Player where name =: name and surname =: surname")
    Player getByNameAndSurname(String name, String surname);
}

