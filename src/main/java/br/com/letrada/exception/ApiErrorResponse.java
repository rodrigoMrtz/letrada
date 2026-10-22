package br.com.letrada.exception;

import java.time.LocalDateTime;

public record ApiErrorResponse(
    int status,
    String message,
    LocalDateTime timestamp
) {
}
