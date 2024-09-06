package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleType;

import java.time.LocalDateTime;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isLicensePlateFormat;
import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isModelFormat;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;

public class VehicleFactory {

    private VehicleFactory(){}

    public static Vehicle createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        validateVehicle(userId, licensePlate, model, vehicleType);
        return new Vehicle(
                new VehicleId(),
                userId,
                licensePlate,
                model,
                vehicleType,
                LocalDateTime.now()
        );
    }

    private static void validateVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        if (isEmpty(userId.getValue())) {
            throw new DomainException(ErrorType.USER_ID_EMPTY.getMessage());
        }
        if (isNull(vehicleType)) {
            throw new DomainException(ErrorType.VEHICLE_TYPE_EMPTY.getMessage());
        }
        if(!isLicensePlateFormat(licensePlate)) {
            throw new DomainException(ErrorType.INVALID_LICENSE_PLATE_FORMAT.getMessage());
        }
        if(!isModelFormat(model)) {
            throw new DomainException(ErrorType.INVALID_MODEL_FORMAT.getMessage());
        }
    }

}
