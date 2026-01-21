package com.ust.springbootmodularbackend.book.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }

}
