package br.com.letrada.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler (WordNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleWordNotFoundException(
        WordNotFoundException exception
    ) {
        ApiErrorResponse response = new ApiErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exception.getMessage(),
            LocalDateTime.now()
        );
        
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(response);
    }
}
