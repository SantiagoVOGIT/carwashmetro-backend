package io.santiagovogit.carwashmetro.domain.cell.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public final class CellId extends Identifier {

    public CellId(UUID value) {
        super(value);
    }

    public CellId() {
        super();
    }

}