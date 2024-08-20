package io.santiagovogit.carwashmetro.domain;

import java.util.Objects;
import java.util.UUID;

public abstract class Identifier {

    private final UUID value;

    protected Identifier(String value) {
        this.value = UUID.fromString(value);
    }

    protected Identifier() {
        this.value = UUID.randomUUID();
    }

    public String getValue() {
        return value.toString();
    }

    public UUID getIdentifier() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}