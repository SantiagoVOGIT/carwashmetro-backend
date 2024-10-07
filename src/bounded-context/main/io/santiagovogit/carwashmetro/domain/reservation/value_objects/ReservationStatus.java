package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

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
            throw new DomainException(ErrorMsg.RESERVATION_STATUS_EMPTY.getMessage());
        }
        for (ReservationStatus status : ReservationStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_RESERVATION_STATUS.getMessage());
    }

}