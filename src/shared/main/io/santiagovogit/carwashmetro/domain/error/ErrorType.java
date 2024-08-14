package io.santiagovogit.carwashmetro.domain.error;

public enum ErrorType {
    VALIDATION_ERROR,
    ENTITY_NOT_FOUND,
    BUSINESS_RULE_VIOLATION,
    CONFLICT,
    EXTERNAL_SERVICE_ERROR,
    UNEXPECTED_ERROR
}