package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class InsuranceManagementExceptionHandler {

    @ExceptionHandler(PolicyNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handlePolicyNotFoundException(PolicyNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(DuplicatePolicyException.class)
    public ResponseEntity<ErrorResponseDto> handleDuplicatePolicyException(DuplicatePolicyException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(ClaimNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleClaimNotFoundException(ClaimNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(DuplicateClaimException.class)
    public ResponseEntity<ErrorResponseDto> handleDuplicateClaimException(DuplicateClaimException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponseDto body = new ErrorResponseDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(body);
    }

}
