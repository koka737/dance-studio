package com.adina.dancestudio.models.entities;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name="reservation")
@Table(name = "reservation")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="reservation_id")
    private Long reservationId;

    @NotNull
    @Column(name="reservations_available_before")
    private Integer reservationsAvailableBefore;

    @NotNull
    @Column(name="reservations_available_after")
    private Integer reservationsAvailableAfter;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id", referencedColumnName = "course_id")
    private Course course;

    public Reservation(Long reservationId, Integer reservationsAvailableBefore, Integer reservationsAvailableAfter) {
        this.reservationId = reservationId;
        this.reservationsAvailableBefore = reservationsAvailableBefore;
        this.reservationsAvailableAfter = reservationsAvailableAfter;
    }

    public Reservation(){
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getReservationsAvailableBefore() {
        return reservationsAvailableBefore;
    }

    public void setReservationsAvailableBefore(Integer reservationsAvailableBefore) {
        this.reservationsAvailableBefore = reservationsAvailableBefore;
    }

    public Integer getReservationsAvailableAfter() {
        return reservationsAvailableAfter;
    }

    public void setReservationsAvailableAfter(Integer reservationsAvailableAfter) {
        this.reservationsAvailableAfter = reservationsAvailableAfter;
    }
}
