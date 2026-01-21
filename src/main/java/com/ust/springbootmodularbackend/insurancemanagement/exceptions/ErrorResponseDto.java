package com.ust.springbootmodularbackend.insurancemanagement.exceptions;

import java.time.LocalDateTime;

public record ErrorResponseDto(LocalDateTime timeStamp, int status, String error, String message, String path) {
}
