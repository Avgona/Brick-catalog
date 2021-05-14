package com.avgona.assignment.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty("Long - unique id")
    private long id;

    @ApiModelProperty("String - nickname")
    @Column(name = "nickname")
    private String nickname;

    @ApiModelProperty("String - type of client")
    @Column(name = "type_of_client")
    private String typeOfClient;

    @ApiModelProperty("Long - id of brick")
    @Column(name = "id_of_brick")
    private long idOfBrick;

    @ApiModelProperty("Int - amount of bought bricks")
    @Column(name = "amount_of_bricks")
    private int amountOfBricks;

    @ApiModelProperty("Float - amount of bought pallets")
    @Column(name = "amount_of_pallets")
    private float amountOfPallet;
}
