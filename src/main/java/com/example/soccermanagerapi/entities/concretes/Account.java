package com.example.soccermanagerapi.entities.concretes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * CREATE TABLE ACCOUNT(
 *    ID INT PRIMARY KEY     NOT NULL,
 *    USERNAME       TEXT    NOT NULL,
 *    EMAIL          CHAR(50)NOT NULL,
 *    PASSWORD       TEXT    NOT NULL
 * );
 */

//Account table
@Data
@Entity
@Table(name="Account")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToOne
    @JoinColumn(name="id")
    private Team team_id;

}


