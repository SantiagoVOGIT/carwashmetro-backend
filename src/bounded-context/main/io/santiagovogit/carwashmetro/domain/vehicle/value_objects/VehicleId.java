package io.santiagovogit.carwashmetro.domain.vehicle.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public final class VehicleId extends Identifier {

    public VehicleId(UUID value) {
        super(value);
    }

    public VehicleId() {
        super();
    }

}