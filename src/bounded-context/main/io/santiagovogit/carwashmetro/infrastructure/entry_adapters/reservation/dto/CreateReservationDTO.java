package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto;

import java.util.UUID;

public record CreateReservationDTO(
        UUID userId,
        UUID cellId,
        UUID vehicleId
) { }
