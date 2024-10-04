package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;
import io.santiagovogit.carwashmetro.domain.error.DomainException;

import java.util.UUID;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.isIdFormat;

public final class ReservationId extends Identifier {

    public ReservationId(UUID value) {
        super(value);
    }

    public ReservationId() {
        super();
    }

    @Override
    public void validateState(UUID value) {
        if (isNull(value)) {
            throw new DomainException(ErrorType.RESERVATION_ID_EMPTY.getMessage());
        }
        if (!isIdFormat(value.toString())) {
            throw new DomainException(ErrorType.INVALID_ID_FORMAT.getMessage());
        }
    }

}