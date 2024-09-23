package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum ReservationStatus {

    PENDING("PENDIENTE"),
    CONFIRMED("CONFIRMADA"),
    CANCELLED("CANCELADA"),
    COMPLETED("COMPLETADA"),
    REJECTED("RECHAZADA");

    private final String value;

    ReservationStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ReservationStatus fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (ReservationStatus status : ReservationStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }

        throw new DomainException(
                ErrorType.INVALID_RESERVATION_STATUS.getMessage(),
                String.format(value)
        );
    }

}