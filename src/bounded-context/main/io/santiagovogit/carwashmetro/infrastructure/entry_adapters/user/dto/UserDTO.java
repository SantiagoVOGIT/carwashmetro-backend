package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDTO(
        UUID id,
        String dniNumber,
        String dniType,
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String role,
        String status,
        LocalDateTime createdAt
) { }
