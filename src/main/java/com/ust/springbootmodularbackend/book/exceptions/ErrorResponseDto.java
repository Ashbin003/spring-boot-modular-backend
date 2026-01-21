package com.ust.springbootmodularbackend.book.exceptions;

import java.time.LocalDateTime;

public record ErrorResponseDto(LocalDateTime timeStamp, int status, String error, String message, String path) {
}
