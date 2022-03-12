package com.example.soccermanagerapi.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="Team")
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="team_total_value")
    private Integer team_total_value;

    @OneToOne(mappedBy = "Team")
    @JoinColumn(name = "id")
    private Account account_id;
}

/*
 CREATE TABLE PLAYER(
ID INT PRIMARY KEY     NOT NULL,
NAME       TEXT    NOT NULL,
COUNTRY          TEXT NOT NULL,
team_total_value       INT    NOT NULL,
account_id INT    NOT NULL
 */