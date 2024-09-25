package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleDTO(
        UUID id,
        UUID userId,
        String licensePlate,
        String model,
        String vehicleType,
        LocalDateTime createdAt
) { }
