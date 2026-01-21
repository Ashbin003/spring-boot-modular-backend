package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}
