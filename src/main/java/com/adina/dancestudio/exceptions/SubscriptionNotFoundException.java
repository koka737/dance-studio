package com.adina.dancestudio.exceptions;

public class SubscriptionNotFoundException extends RuntimeException{
    private Long subscriptionId;
    public SubscriptionNotFoundException(String message, Long subscriptionId) {
        super(message);
        this.subscriptionId = subscriptionId;
    }
    public Long getSubscriptionId() {
        return subscriptionId;
    }
}
