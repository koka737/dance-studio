package com.adina.dancestudio.exceptions;

public class ReservationNotFoundException extends RuntimeException{
    private Long reservationId;
    public ReservationNotFoundException(String message, Long reservationId) {
        super(message);
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return reservationId;
    }
}
