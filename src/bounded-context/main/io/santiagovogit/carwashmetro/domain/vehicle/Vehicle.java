package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.ZonedDateTime;

public class Vehicle {

    private final VehicleId vehicleId;

    private final UserId userId;

    private final String licensePlate;

    private final String model;

    private final VehicleType vehicleType;

    private final ZonedDateTime createdAt;


    public Vehicle(VehicleId vehicleId, UserId userId, String licensePlate, String model, VehicleType vehicleType, ZonedDateTime createdAt) {
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.vehicleType = vehicleType;
        this.createdAt = createdAt;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

}
