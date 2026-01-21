package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

public class DuplicatePolicyException extends RuntimeException {
    public DuplicatePolicyException(String message) {
        super(message);
    }
}
