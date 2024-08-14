package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;

public final class EmployeeId extends Identifier {

    public EmployeeId(String value) {
        super(value);
    }

    public EmployeeId() {
        super();
    }

}