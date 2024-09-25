package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.vehicle.dto;

import java.util.UUID;

public class CreateVehicleDTO {

    private UUID userId;
    private String licensePlate;
    private String model;
    private String vehicleType;

    public UUID getUserId() {
        return userId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

}
