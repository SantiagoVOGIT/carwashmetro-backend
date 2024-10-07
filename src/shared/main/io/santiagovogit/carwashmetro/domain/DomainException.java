package io.santiagovogit.carwashmetro.domain;

public class DomainException extends RuntimeException {

    private final String message;
    private final String details;

    public DomainException(String message) {
        this(message, null);
    }

    public DomainException(String message, String details) {
        this.message = message;
        this.details = details;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}