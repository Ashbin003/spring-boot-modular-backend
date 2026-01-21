package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

public class DuplicateClaimException extends RuntimeException {
    public DuplicateClaimException(String message) {
        super(message);
    }
}
