package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CellDTO(
        UUID id,
        String spaceNumber,
        String vehicleType,
        String status,
        LocalDateTime createdAt
) { }