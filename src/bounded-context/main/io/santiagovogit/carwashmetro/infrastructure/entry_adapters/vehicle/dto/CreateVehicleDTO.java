package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto;

import java.util.UUID;

public record CreateVehicleDTO(
        UUID userId,
        String licensePlate,
        String model,
        String vehicleType
) { }
