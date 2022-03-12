package com.example.soccermanagerapi.core.utilities.util;

import com.example.soccermanagerapi.entities.concretes.Player;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class createRandomTeam {

    public static List<Player> createRandTeamPlayer(String position, int repeat, int teamId){
        List<Player> playerList = new ArrayList<>();
        Player player = new Player();
        Faker faker = new Faker();
        for(int i=0; i<repeat; i++){
            player.setId(teamId);
            player.setName(faker.name().fullName());
            player.setSurname(faker.name().lastName());
            player.setAge(faker.number().numberBetween(18,40));
            player.setCountry(faker.address().country());
            player.setInitial_value(1000000);
            player.setPosition(position);
            player.setTeam_id(teamId);

            playerList.add(player);
        }
        return playerList;
    }
}
