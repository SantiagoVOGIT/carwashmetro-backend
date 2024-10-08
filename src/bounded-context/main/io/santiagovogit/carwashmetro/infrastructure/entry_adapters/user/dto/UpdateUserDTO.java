package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.user.dto;

public record UpdateUserDTO(
        String firstName,
        String lastName,
        String dniNumber,
        String dniType,
        String phoneNumber,
        String email,
        String role,
        String status
) { }
