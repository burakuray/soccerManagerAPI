package com.example.soccermanagerapi.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="Transfer")
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="player_id")
    private Integer playerId;

    @Column(name="player_value")
    private Integer playerValue;

    @Column(name="transfered_price")
    private Integer transferedPrice;

    @Column(name="transfered_price_from")
    private Integer transferedPriceFrom;
}

/*
 * CREATE TABLE ACCOUNT(
 *    ID INT PRIMARY KEY     NOT NULL,
 *    player_id       INT    NOT NULL,
 *    transfered_price          INT    NOT NULL,
 *    player_value       INT    NOT NULL
 *    player_value_from       INT    NOT NULL
 * );
 */