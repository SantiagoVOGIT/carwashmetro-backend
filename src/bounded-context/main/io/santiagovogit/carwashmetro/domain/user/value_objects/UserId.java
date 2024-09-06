package io.santiagovogit.carwashmetro.domain.user.value_objects;


import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public final class UserId extends Identifier {

    public UserId(UUID value) {
        super(value);
    }

    public UserId() {
        super();
    }

}