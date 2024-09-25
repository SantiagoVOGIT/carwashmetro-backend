package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeDTO(
        UUID id,
        UUID userId,
        String position,
        int salary,
        String status,
        LocalDateTime createdAt
) { }
