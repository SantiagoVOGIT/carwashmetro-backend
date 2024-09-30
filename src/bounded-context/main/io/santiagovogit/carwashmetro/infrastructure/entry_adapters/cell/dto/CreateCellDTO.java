package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.cell.dto;

public record CreateCellDTO(
        String spaceNumber,
        String vehicleType,
        String status
) { }