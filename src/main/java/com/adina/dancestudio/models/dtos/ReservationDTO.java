package com.adina.dancestudio.models.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationDTO {
    private Integer reservationsAvailableBefore;
    private Integer reservationsAvailableAfter;

    public void setReservationsAvailableBefore(Integer reservationsAvailableBefore) {
        this.reservationsAvailableBefore = reservationsAvailableBefore;
    }

    public void setReservationsAvailableAfter(Integer reservationsAvailableAfter) {
        this.reservationsAvailableAfter = reservationsAvailableAfter;
    }
}
