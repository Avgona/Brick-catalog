package com.avgona.assignment.service.impl;

import com.avgona.assignment.models.Reservation;
import com.avgona.assignment.repository.ReservationRepository;
import com.avgona.assignment.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
