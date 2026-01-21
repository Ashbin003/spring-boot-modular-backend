package com.ust.springbootmodularbackend.book.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BookApiExceptionHandler {

    @ExceptionHandler(DuplicateBookFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleDuplicateBoookException(DuplicateBookFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleBodyValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation failed");
        return ResponseEntity.status(status).body(
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        message,
                        request.getRequestURI()
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleParamValidation(ConstraintViolationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = e.getConstraintViolations()
                .stream()
                .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                .findFirst()
                .orElse("Invalid request parameter");
        return ResponseEntity.status(status).body(
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        message,
                        request.getRequestURI()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAll(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(
                new ErrorResponseDto(
                        LocalDateTime.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        e.getMessage(),
                        request.getRequestURI()
                )
        );
    }

}
