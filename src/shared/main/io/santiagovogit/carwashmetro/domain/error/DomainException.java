package io.santiagovogit.carwashmetro.domain.error;

public class DomainException extends RuntimeException {

    private final String errorType;
    private final String details;

    public DomainException(String messageKey) {
        this(messageKey, null);
    }

    public DomainException(String messageKey, String details) {
        this.errorType = messageKey;
        this.details = details != null ? details : "";
    }

    @Override
    public String getMessage() {
        return errorType;
    }

    public String getDetails() {
        return details;
    }

}