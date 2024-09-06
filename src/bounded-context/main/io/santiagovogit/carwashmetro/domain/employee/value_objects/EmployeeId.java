package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

import java.util.UUID;

public final class EmployeeId extends Identifier {

    public EmployeeId(UUID value) {
        super(value);
    }

    public EmployeeId() {
        super();
    }

}