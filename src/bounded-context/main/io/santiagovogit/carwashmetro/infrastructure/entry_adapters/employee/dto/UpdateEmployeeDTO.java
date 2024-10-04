package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto;

public record UpdateEmployeeDTO(
        String position,
        int salary,
        String status
) { }
