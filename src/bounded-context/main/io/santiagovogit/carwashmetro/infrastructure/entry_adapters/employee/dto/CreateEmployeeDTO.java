package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.employee.dto;


import java.util.UUID;

public class CreateEmployeeDTO {

    private UUID userId;
    private String position;
    private int salary;
    private String status;

    public UUID getUserId() {
        return userId;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

}