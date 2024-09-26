package io.santiagovogit.carwashmetro.domain.reservation.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class ReservationCode extends Identifier {

    private final String value;

    public ReservationCode() {
        super();
        this.value = generateCode();
    }

    public ReservationCode(String value) {
        super();
        this.value = value;
    }

    private static String generateCode() {
        return UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 10)
                .toUpperCase();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationCode that = (ReservationCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

}