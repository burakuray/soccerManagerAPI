package com.example.soccermanagerapi.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Player")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="age")
    private int age;

    @Column(name="country")
    private String country;

    @Column(name="initial_value")
    private Integer initial_value;

    @Column(name="position")
    private String position;

    @Column(name="team_id")
    private int team_id;

    public Player(String fullName, String lastName, int numberBetween, String country, int i, String position, int teamId) {
    }
}
/*
 CREATE TABLE PLAYER(
ID INT PRIMARY KEY     NOT NULL,
TEAM_ID     INT      NOT NULL,
NAME       TEXT    NOT NULL,
SURNAME          TEXT NOT NULL,
AGE       INT    NOT NULL,
COUNTRY          TEXT NOT NULL,
INITIAL_VALUE       INT    NOT NULL,
POSITION       TEXT    NOT NULL,
TEAM_ID       INT    NOT NULL);
 */

