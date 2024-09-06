package io.santiagovogit.carwashmetro.infrastructure.entry_adapters.error;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public class ErrorId extends Identifier {

    public ErrorId(UUID value) {
        super(value);
    }

    public ErrorId() {
        super();
    }
}
