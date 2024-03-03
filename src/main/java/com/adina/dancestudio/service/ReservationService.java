package com.adina.dancestudio.service;
import com.adina.dancestudio.models.dtos.ReservationDTO;
import com.adina.dancestudio.models.entities.Reservation;
import com.adina.dancestudio.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    public ReservationDTO getReservationById(Long reservationId){
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setReservationsAvailableBefore(reservation.getReservationsAvailableBefore());
            reservationDTO.setReservationsAvailableAfter(reservation.getReservationsAvailableAfter());
            return reservationDTO;
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setReservationsAvailableBefore(reservationDTO.getReservationsAvailableBefore());
        reservation.setReservationsAvailableAfter(reservationDTO.getReservationsAvailableAfter());

        reservationRepository.save(reservation);
    }
    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();
            // Update properties
            existingReservation.setReservationsAvailableBefore(updatedReservation.getReservationsAvailableBefore());
            existingReservation.setReservationsAvailableAfter(updatedReservation.getReservationsAvailableAfter());

            // Save and return the updated reservation
            return reservationRepository.save(existingReservation);
        } else {
            // Handle not found scenario
            return null;
        }
    }

    public void deleteReservation(Long reservationId) {
        // Delete the subscription by ID
        reservationRepository.deleteById(reservationId);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> findByReservationsAvailableBefore(Integer reservationsAvailableBefore) {
        return reservationRepository.findByReservationsAvailableBeforeJPQL(reservationsAvailableBefore);
    }

    public List<Reservation> findByReservationsAvailableAfter(Integer reservationsAvailableAfter) {
        return reservationRepository.findByReservationsAvailableAfterJPQL(reservationsAvailableAfter);
    }

}
