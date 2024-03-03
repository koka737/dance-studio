package com.adina.dancestudio.service;

import com.adina.dancestudio.models.dtos.SubscriptionDTO;
import com.adina.dancestudio.models.entities.Subscription;
import com.adina.dancestudio.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
    public SubscriptionDTO getSubscriptionById(Long subscriptionId){
        Subscription subscription= subscriptionRepository.getReferenceById(subscriptionId);

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setCardNumber(subscription.getCardNumber());
        subscriptionDTO.setPaydSum(subscription.getPaydSum());
        subscriptionDTO.setFullName(subscription.getFullName());
        subscriptionDTO.setPhoneNumber(subscription.getPhoneNumber());
        subscriptionDTO.setEmailAdress(subscription.getEmailAdress());
        subscriptionDTO.setCardExpirationDate(subscription.getCardExpirationDate());
        subscriptionDTO.setCardCvvCode(subscription.getCardCvvCode());
        subscriptionDTO.setSubscriptionPurchased(subscription.getSubscriptionPurchased());
        subscriptionDTO.setReservationDuration(subscription.getReservationDuration());
        subscriptionDTO.setPaymentStatus(subscription.getPaymentStatus());

        return subscriptionDTO;
    }

    public void createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription();

        subscription.setCardNumber(subscriptionDTO.getCardNumber());
        subscription.setPaydSum(subscriptionDTO.getPaydSum());
        subscription.setFullName(subscriptionDTO.getFullName());
        subscription.setPhoneNumber(subscriptionDTO.getPhoneNumber());
        subscription.setEmailAdress(subscriptionDTO.getEmailAdress());
        subscription.setCardExpirationDate(subscriptionDTO.getCardExpirationDate());
        subscription.setCardCvvCode(subscriptionDTO.getCardCvvCode());
        subscription.setSubscriptionPurchased(subscriptionDTO.getSubscriptionPurchased());
        subscription.setReservationDuration(subscriptionDTO.getReservationDuration());
        subscription.setPaymentStatus(subscriptionDTO.getPaymentStatus());

        subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(Integer subscriptionId, Subscription updatedSubscription) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(Long.valueOf(subscriptionId));
        if (optionalSubscription.isEmpty()) {
            return null;
        }
        Subscription existingSubscription = optionalSubscription.get();
        // Update properties
        existingSubscription.setCardNumber(updatedSubscription.getCardNumber());
        existingSubscription.setPaydSum(updatedSubscription.getPaydSum());
        existingSubscription.setFullName(updatedSubscription.getFullName());
        existingSubscription.setPhoneNumber(updatedSubscription.getPhoneNumber());
        existingSubscription.setEmailAdress(updatedSubscription.getEmailAdress());
        existingSubscription.setCardExpirationDate(updatedSubscription.getCardExpirationDate());
        existingSubscription.setCardCvvCode(updatedSubscription.getCardCvvCode());
        existingSubscription.setSubscriptionPurchased(updatedSubscription.getSubscriptionPurchased());
        existingSubscription.setReservationDuration(updatedSubscription.getReservationDuration());
        existingSubscription.setPaymentStatus(updatedSubscription.getPaymentStatus());

        // Save and return the updated subscription
        return subscriptionRepository.save(existingSubscription);
    }

    public void deleteSubscription(Long subscriptionId) {
        // Delete the subscription by ID
        subscriptionRepository.deleteById(subscriptionId);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
