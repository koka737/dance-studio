package com.adina.dancestudio.repositories;
import com.adina.dancestudio.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long reservationId);

    // using the naming convention
    /*List<Reservation> findByReservationsAvailableBefore(Integer reservationsAvailableBefore);

    List<Reservation> findByReservationsAvailableAfter(Integer reservationsAvailableAfter);*/

    @Query("SELECT r FROM reservations r WHERE r.reservationsAvailableBefore = :reservationsAvailableBefore")
    List<Reservation> findByReservationsAvailableBeforeJPQL(Integer reservationsAvailableBefore);
    @Query("SELECT r FROM reservations r WHERE r.reservationsAvailableAfter = :reservationsAvailableAfter")
    List<Reservation> findByReservationsAvailableAfterJPQL(Integer reservationsAvailableAfter);
}

