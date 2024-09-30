package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto;

import java.util.UUID;

public record CreateEmployeeDTO(
        UUID userId,
        String position,
        int salary,
        String status
) { }
