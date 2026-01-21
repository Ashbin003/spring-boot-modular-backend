package com.ust.springbootmodularbackend.book.exceptions;

public class DuplicateBookFoundException extends RuntimeException{

    public DuplicateBookFoundException(String message) {
        super(message);
    }
}
