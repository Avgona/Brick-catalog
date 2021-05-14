package com.avgona.assignment.service;


import com.avgona.assignment.models.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    void save(Reservation reservation);
}
