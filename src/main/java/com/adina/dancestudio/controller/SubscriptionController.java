package com.adina.dancestudio.controller;

import com.adina.dancestudio.exceptions.SubscriptionNotFoundException;
import com.adina.dancestudio.models.dtos.SubscriptionDTO;
import com.adina.dancestudio.models.entities.Subscription;
import com.adina.dancestudio.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/{id}")
    public SubscriptionDTO getSubscriptionById(@PathVariable("id") Long subscription_id){
        return subscriptionService.getSubscriptionById(subscription_id) ;
    }

    @PostMapping("/")
    public ResponseEntity<?> createSubscription(@PathVariable Integer id, @RequestBody SubscriptionDTO subscriptionDTO){
        try {
            subscriptionService.createSubscription(subscriptionDTO);

            String message = String.format("Subscription with ID %d was created", id);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }catch(SubscriptionNotFoundException e){
            String errorMessage = "Wrong request!";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }


    // Get all subscriptions
    @GetMapping("/")
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        return ResponseEntity.ok(subscriptions);
    }
    // Update subscription
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSubscription(@PathVariable Integer id, @RequestBody Subscription subscription) {
        try {
            Subscription updatedSubscription = subscriptionService.updateSubscription(id, subscription);
            if (updatedSubscription == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedSubscription);
        } catch (SubscriptionNotFoundException e) {
             Integer subscriptionId = id; // Use the provided ID directly from the path variable
            // Construct a custom error message
            String errorMessage = String.format("Subscription with ID %d can't be updated", subscriptionId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    // Delete subscription by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubscription(@PathVariable Long id) {
        try {
            subscriptionService.deleteSubscription(id);
            return ResponseEntity.noContent().build();
        } catch (SubscriptionNotFoundException e) {
            Long subscriptionId = e.getSubscriptionId();
            // Construct a custom error message
            String errorMessage = String.format("Subscription with ID %d was not found", subscriptionId);
            // Return NOT_FOUND with the custom error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
}
