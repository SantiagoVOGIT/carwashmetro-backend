package io.santiagovogit.carwashmetro.domain;

import java.io.Serializable;
import java.util.UUID;

public abstract class Identifier implements Serializable {

    private final UUID value;

    protected Identifier(UUID value) {
        validateState(value);
        this.value = value;
    }

    protected Identifier() {
        this.value = UUID.randomUUID();
    }

    public UUID getIdentifier() {
        return value;
    }

    public String getValue() {
        return value.toString();
    }

    public abstract void validateState(UUID value);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}