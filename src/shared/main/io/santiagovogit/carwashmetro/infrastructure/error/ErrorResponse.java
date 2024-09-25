package io.santiagovogit.carwashmetro.infrastructure.error;


import java.time.LocalDateTime;
import java.util.UUID;

public record ErrorResponse(UUID errorId, String error, String message, String details, LocalDateTime timestamp) { }