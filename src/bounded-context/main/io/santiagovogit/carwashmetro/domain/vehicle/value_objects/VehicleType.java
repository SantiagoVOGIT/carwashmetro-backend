package io.santiagovogit.carwashmetro.domain.vehicle.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum VehicleType {

    CAR("AUTOMOVIL"),
    MOTORCYCLE("MOTOCICLETA");

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static VehicleType fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (VehicleType status : VehicleType.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }

        throw new DomainException(
                ErrorType.INVALID_USER_STATUS.getMessage(),
                String.format(value)
        );
    }

}
