package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;

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
            throw new DomainException(ErrorMsg.RESERVATION_ID_EMPTY.getMessage());
        }
        if (!isIdFormat(value.toString())) {
            throw new DomainException(ErrorMsg.INVALID_ID_FORMAT.getMessage());
        }
    }

}