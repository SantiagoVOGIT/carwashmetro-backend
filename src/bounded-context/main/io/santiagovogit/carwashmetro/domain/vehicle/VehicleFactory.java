package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.isLicensePlateFormat;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.isModelFormat;

public class VehicleFactory {

    private VehicleFactory(){}

    public static Vehicle createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        validateVehicle(licensePlate, model, vehicleType);
        return new Vehicle(
                new VehicleId(),
                userId,
                licensePlate,
                model,
                vehicleType,
                LocalDateTime.now()
        );
    }

    private static void validateVehicle(String licensePlate, String model, VehicleType vehicleType) {
        if (isNull(vehicleType)) {
            throw new DomainException(ErrorMsg.VEHICLE_TYPE_EMPTY.getMessage());
        }
        if(!isLicensePlateFormat(licensePlate)) {
            throw new DomainException(ErrorMsg.INVALID_LICENSE_PLATE_FORMAT.getMessage());
        }
        if(!isModelFormat(model)) {
            throw new DomainException(ErrorMsg.INVALID_MODEL_FORMAT.getMessage());
        }
    }

}
