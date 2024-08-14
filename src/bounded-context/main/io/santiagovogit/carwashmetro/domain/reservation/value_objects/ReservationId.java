package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

public final class ReservationId extends Identifier {

    public ReservationId(String value) {
        super(value);
    }

    public ReservationId() {
        super();
    }

}