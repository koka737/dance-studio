package com.adina.dancestudio.models.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionDTO {
    private Integer cardNumber;
    private Integer paydSum;
    private String fullName;
    private Integer phoneNumber;
    private String emailAdress;
    private Integer cardExpirationDate;
    private Integer cardCvvCode;
    private String subscriptionPurchased;
    private String reservationDuration;
    private String paymentStatus;

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPaydSum(Integer paydSum) {
        this.paydSum = paydSum;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void setCardExpirationDate(Integer cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public void setCardCvvCode(Integer cardCvvCode) {
        this.cardCvvCode = cardCvvCode;
    }

    public void setSubscriptionPurchased(String subscriptionPurchased) {
        this.subscriptionPurchased = subscriptionPurchased;
    }

    public void setReservationDuration(String reservationDuration) {
        this.reservationDuration = reservationDuration;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
