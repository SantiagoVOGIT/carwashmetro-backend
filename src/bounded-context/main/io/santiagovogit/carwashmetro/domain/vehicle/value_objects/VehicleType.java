package io.santiagovogit.carwashmetro.domain.vehicle.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import java.util.Arrays;

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
        return Arrays.stream(VehicleType.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new DomainException(
                        ErrorType.INVALID_VEHICLE_TYPE.getMessage(),
                        String.format(value)
                ));
    }

}
