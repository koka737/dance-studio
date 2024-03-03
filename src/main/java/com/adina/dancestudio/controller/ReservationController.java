package com.adina.dancestudio.controller;

import com.adina.dancestudio.exceptions.ReservationNotFoundException;
import com.adina.dancestudio.models.dtos.ReservationDTO;

import com.adina.dancestudio.models.entities.Reservation;
import com.adina.dancestudio.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable("id") Long reservation_id){
        return reservationService.getReservationById(reservation_id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createReservation(@PathVariable Integer id, @RequestBody ReservationDTO reservationDTO){
        try {
            reservationService.createReservation(reservationDTO);

            String message = String.format("Reservation with ID %d was created", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }catch(ReservationNotFoundException e){
            String errorMessage = "Wrong request!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    // Retrieve all reservations
    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
    // Update an existing reservation
    @PutMapping("/{id}/update")
    public ResponseEntity<Object> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            Reservation updatedReservation = reservationService.updateReservation(id, reservation);
            if (updatedReservation == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedReservation);
        } catch (ReservationNotFoundException e) {
            // Construct a custom error message
            String errorMessage = String.format("Reservation with ID %d can't be updated", id);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    // Delete a reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (ReservationNotFoundException e) {
            Long reservationId = e.getReservationId();
            // Construct a custom error message
            String errorMessage = String.format("Reservation with ID %d was not found", reservationId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
