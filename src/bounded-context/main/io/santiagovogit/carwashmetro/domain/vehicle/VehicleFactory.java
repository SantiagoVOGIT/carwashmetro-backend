package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.time.ZonedDateTime;

public class VehicleFactory {

    public static Vehicle createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType){
        return new Vehicle(
                new VehicleId(),
                userId,
                licensePlate,
                model,
                vehicleType,
                ZonedDateTime.now()
        );
    }

}
