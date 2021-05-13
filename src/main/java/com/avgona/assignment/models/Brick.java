package com.avgona.assignment.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bricks")
public class Brick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "color")
    private String color;

    @Column(name = "amount_of_bricks")
    private int amountOfBricks;

    @Column(name = "amount_of_pallets")
    private float amountOfPallet;

    @Column(name = "amount_of_bricks_in_pallet")
    private int amountOfBricksInPallet;
}
