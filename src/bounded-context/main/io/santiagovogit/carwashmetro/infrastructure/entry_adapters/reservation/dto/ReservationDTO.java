package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.reservation.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReservationDTO(
        UUID id,
        UUID userId,
        UUID cellId,
        UUID vehicleId,
        String reservationCode,
        String status,
        LocalDateTime startTime,
        LocalDateTime endTime,
        LocalDateTime createdAt
) { }