package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.error;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.infrastructure.error.ErrorId;
import io.santiagovogit.carwashmetro.infrastructure.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Unexpected exception occurred", ex);
        String details = ex.getCause() != null ? ex.getCause().toString() : null;
        return createErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, details);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        log.error("Domain exception occurred", ex);
        String details = ex.getCause() != null ? ex.getDetails() : null;
        return createErrorResponse(ex, HttpStatus.BAD_REQUEST, details);
    }

    private ResponseEntity<ErrorResponse> createErrorResponse(Exception ex, HttpStatus status, String details) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorId(new ErrorId())
                .error(status.getReasonPhrase())
                .message(ex.getMessage())
                .details(details)
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

}