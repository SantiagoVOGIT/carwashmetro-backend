package io.santiagovogit.carwashmetro.domain.error;

import java.util.HashMap;
import java.util.Map;

public class DomainException extends RuntimeException {

    private final ErrorType errorType;
    private final String messageKey;
    private final Map<String, Object> details;

    public DomainException(ErrorType errorType, String messageKey) {
        this(errorType, messageKey, null);
    }

    public DomainException(ErrorType errorType, String messageKey, Map<String, Object> details) {
        this.errorType = errorType;
        this.messageKey = messageKey;
        this.details = details != null ? details : new HashMap<>();
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}