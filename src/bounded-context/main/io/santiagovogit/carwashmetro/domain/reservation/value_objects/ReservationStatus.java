package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

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

}