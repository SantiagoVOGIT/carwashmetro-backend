package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.util.Date;

public class Vehicle {

    private final VehicleId id;

    private final UserId userId;

    private final String licensePlate;

    private final String model;

    private final VehicleType vehicleType;

    private final Date createdAt;


    public Vehicle(VehicleId id,
                   UserId userId,
                   String licensePlate,
                   String model,
                   VehicleType vehicleType,
                   Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.licensePlate = licensePlate;
        this.model = model;
        this.vehicleType = vehicleType;
        this.createdAt = createdAt;
    }

    public VehicleId getId() {
        return id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + id +
                ", userId=" + userId +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", vehicleType=" + vehicleType +
                ", createdAt=" + createdAt +
                '}';
    }

}
