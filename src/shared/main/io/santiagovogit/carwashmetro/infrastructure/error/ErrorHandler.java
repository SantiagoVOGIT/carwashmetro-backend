package io.santiagovogit.carwashmetro.infrastructure.error;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
public class ErrorHandler {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handleDomainException(DomainException exc) {
        return handleException(exc, HttpStatus.BAD_REQUEST, "Domain exception occurred");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exc) {
        return handleException(exc, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected exception occurred");
    }

    private ResponseEntity<ErrorResponse> handleException(Exception exc, HttpStatus status, String logMessage) {
        logger.error(logMessage, exc);
        String details = getExceptionDetails(exc);
        ErrorResponse response = new ErrorResponse(
                UUID.randomUUID(),
                status.getReasonPhrase(),
                exc.getMessage(),
                details,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, status);
    }

    private String getExceptionDetails(Exception exc) {
        if (exc instanceof DomainException domainException) {
            return domainException.getDetails();
        }
        return exc.getCause() != null ? exc.getCause().toString() : null;
    }

}
