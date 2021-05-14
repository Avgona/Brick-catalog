package com.avgona.assignment.controllers;

import com.avgona.assignment.models.Reservation;
import com.avgona.assignment.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ApiOperation(value = "Find all reservations")
    @GetMapping
    public List<Reservation> getReservations(){
        return reservationService.findAll();
    }

    @ApiOperation(value = "Save new reservation")
    @PostMapping
    public void save(Reservation reservation){
        reservationService.save(reservation);
    }
}
