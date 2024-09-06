package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public final class ReservationId extends Identifier {

    public ReservationId(UUID value) {
        super(value);
    }

    public ReservationId() {
        super();
    }

}