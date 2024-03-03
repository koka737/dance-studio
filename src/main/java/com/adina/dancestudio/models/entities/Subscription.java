package com.adina.dancestudio.models.entities;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity(name = "subscription")
@Table(name = "subscription")
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="subscription_id")
    private Long subscriptionId;

    @NotNull
    @Column(name="card_number")
    private Integer cardNumber;

    @NotNull
    @Column(name="payd_sum")
    private Integer paydSum;

    @NotNull
    @Column(name="full_name")
    private String fullName;

    @NotNull
    @Column(name="phone_number")
    private Integer phoneNumber;

    @NotNull
    @Column(name="email_adress")
    private String emailAdress;

    @NotNull
    @Column(name="card_expiration_date")
    private Integer cardExpirationDate;

    @NotNull
    @Column(name="card_cvv_code")
    private Integer cardCvvCode;

    @NotNull
    @Column(name="subscription_purchased")
    private String subscriptionPurchased;

    @NotNull
    @Column(name="reservation_duration")
    private String reservationDuration;

    @NotNull
    @Column(name="payment_status")
    private String paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    public Subscription(Long subscriptionId, Integer cardNumber, Integer paydSum, String fullName, Integer phoneNumber, String emailAdress, Integer cardExpirationDate, Integer cardCvvCode, String subscriptionPurchased, String reservationDuration, String paymentStatus) {
        this.subscriptionId = subscriptionId;
        this.cardNumber = cardNumber;
        this.paydSum = paydSum;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCvvCode = cardCvvCode;
        this.subscriptionPurchased = subscriptionPurchased;
        this.reservationDuration = reservationDuration;
        this.paymentStatus = paymentStatus;
    }
    public Subscription(){
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getPaydSum() {
        return paydSum;
    }

    public void setPaydSum(Integer paydSum) {
        this.paydSum = paydSum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Integer getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(Integer cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public Integer getCardCvvCode() {
        return cardCvvCode;
    }

    public void setCardCvvCode(Integer cardCvvCode) {
        this.cardCvvCode = cardCvvCode;
    }

    public String getSubscriptionPurchased() {
        return subscriptionPurchased;
    }

    public void setSubscriptionPurchased(String subscriptionPurchased) {
        this.subscriptionPurchased = subscriptionPurchased;
    }

    public String getReservationDuration() {
        return reservationDuration;
    }

    public void setReservationDuration(String reservationDuration) {
        this.reservationDuration = reservationDuration;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
