package com.avgona.assignment.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "type_of_client")
    private String typeOfClient;

    @Column(name = "id_of_brick")
    private long idOfBrick;

    @Column(name = "amount_of_bricks")
    private int amountOfBricks;

    @Column(name = "amount_of_pallets")
    private float amountOfPallet;
}
