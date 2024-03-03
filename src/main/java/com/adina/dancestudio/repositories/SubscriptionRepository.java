package com.adina.dancestudio.repositories;
import com.adina.dancestudio.models.entities.Subscription;
import com.adina.dancestudio.models.entities.Subscription;
import com.adina.dancestudio.models.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{


    Optional<Subscription> getBySubscriptionId(Long subscriptionId);
    List<Subscription> findByCardNumber(Integer cardNumber);
    List<Subscription> findByPaydSum(Integer paydSum);
    List<Subscription> findByFullName(String fullName);
    List<Subscription> findByPhoneNumber(Integer phoneNumber);
    List<Subscription> findByEmailAdress(String emailAdress);
    List<Subscription> findByCardExpirationDate(Integer cardExpirationDate);
    List<Subscription> findByCardCvvCode(Integer cardCvvCode);

    List<Subscription> findBySubscriptionPurchased(String subscriptionPurchased);

    List<Subscription> findByReservationDuration(String reservationDuration);

    List<Subscription> findByPaymentStatus(String paymentStatus);

    @Query("SELECT s FROM subscriptions s WHERE s.cardNumber = :cardNumber")
    List<Subscription> findByCardNumberJPQL(Integer cardNumber);
    @Query("SELECT s FROM subscriptions s WHERE s.paydSum = :paydSum")
    List<Subscription> findByPaydSumJPQL(Integer paydSum);
    @Query("SELECT s FROM subscriptions s WHERE s.fullName = :fullName")
    List<Subscription> findByFullNameJPQL(String fullName);
    @Query("SELECT s FROM subscriptions s WHERE s.phoneNumber = :phoneNumber")
    List<Subscription> findByAccountPasswordJPQL(Integer phoneNumber);
    @Query("SELECT s FROM subscriptions s WHERE s.emailAdress = :emailAdress")
    List<Subscription> findByEmailAdressJPQL(String emailAdress);
    @Query("SELECT s FROM subscriptions s WHERE s.cardExpirationDate = :cardExpirationDate")
    List<Subscription> ffindByCardExpirationDateJPQL(Integer cardExpirationDate);
    @Query("SELECT s FROM subscriptions s WHERE s.cardCvvCode = :cardCvvCode")
    List<Subscription> findByCardCvvCodeJPQL(Integer cardCvvCode);
    @Query("SELECT s FROM subscriptions s WHERE s.subscriptionPurchased = :subscriptionPurchased")
    List<Subscription> findBySubscriptionPurchasedJPQL(String subscriptionPurchased);
    @Query("SELECT s FROM subscriptions s WHERE s.reservationDuration = :reservationDuration")
    List<Subscription> findByReservationDurationJPQL(String reservationDuration);
    @Query("SELECT s FROM subscriptions s WHERE s.paymentStatus = :paymentStatus")
    List<Subscription> findByPaymentStatusJPQL(String paymentStatus);
}
