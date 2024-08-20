package io.santiagovogit.carwashmetro.domain.vehicle;

import io.santiagovogit.carwashmetro.domain.VehicleType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorMessage;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;
import io.santiagovogit.carwashmetro.domain.user.value_objects.UserId;
import io.santiagovogit.carwashmetro.domain.vehicle.value_objects.VehicleId;

import java.util.Date;

import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isLicensePlateFormat;
import static io.santiagovogit.carwashmetro.domain.StringDomainUtils.isModelFormat;
import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

public class VehicleFactory {

    private VehicleFactory(){}

    public static Vehicle createVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType){
        validateVehicle(userId, licensePlate, model, vehicleType);

        return new Vehicle(
                new VehicleId(),
                userId,
                licensePlate,
                model,
                vehicleType,
                new Date()
        );
    }

    private static void validateVehicle(UserId userId, String licensePlate, String model, VehicleType vehicleType) {
        validateNotNull(userId, ErrorMessage.USER_ID_NULL.getMessage());
        validateNotNull(vehicleType, ErrorMessage.VEHICLE_TYPE_NULL.getMessage());

        if(!isLicensePlateFormat(licensePlate)){
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_LICENSE_PLATE_FORMAT.getMessage()
            );
        }
        if(!isModelFormat(model)){
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    ErrorMessage.INVALID_MODEL_FORMAT.getMessage()
            );
        }

    }

}
