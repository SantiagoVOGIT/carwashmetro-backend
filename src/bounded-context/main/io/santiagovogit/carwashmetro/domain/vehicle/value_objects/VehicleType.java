package io.santiagovogit.carwashmetro.domain.vehicle.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;
import io.santiagovogit.carwashmetro.domain.cell.value_objects.SpaceNumber;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotNull;

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
        validateNotNull(value, ErrorType.VEHICLE_TYPE_NULL.getMessage());
        return EnumUtils.fromValue(
                VehicleType.class,
                VehicleType::getValue,
                value,
                ErrorType.INVALID_VEHICLE_TYPE.getMessage()
        );
    }

}
