package com.avgona.assignment.models;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bricks")
public class Brick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty("Long - unique id")
    private long id;

    @ApiModelProperty("String - color of brick")
    @Column(name = "color")
    private String color;

    @ApiModelProperty("Int - amount of bricks")
    @Column(name = "amount_of_bricks")
    private int amountOfBricks;

    @ApiModelProperty("Float - amount of pallets")
    @Column(name = "amount_of_pallets")
    private float amountOfPallet;

    @ApiModelProperty("Int - amount of bricks in 1 pallet")
    @Column(name = "amount_of_bricks_in_pallet")
    private int amountOfBricksInPallet;
}
