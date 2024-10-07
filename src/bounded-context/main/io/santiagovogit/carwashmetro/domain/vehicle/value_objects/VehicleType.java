package io.santiagovogit.carwashmetro.domain.vehicle.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

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
            throw new DomainException(ErrorMsg.VEHICLE_TYPE_EMPTY.getMessage());
        }

        for (VehicleType status : VehicleType.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_VEHICLE_TYPE.getMessage());
    }

}
