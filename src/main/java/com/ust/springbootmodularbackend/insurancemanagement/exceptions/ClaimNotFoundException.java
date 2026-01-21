package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

public class ClaimNotFoundException extends RuntimeException {
    public ClaimNotFoundException(String message) {
        super(message);
    }
}
