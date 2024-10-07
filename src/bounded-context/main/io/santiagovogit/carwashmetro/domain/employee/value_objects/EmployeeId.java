package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.Identifier;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;
import io.santiagovogit.carwashmetro.domain.DomainException;

import java.util.UUID;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isNull;
import static io.santiagovogit.carwashmetro.domain.common.DomainUtils.isIdFormat;

public final class EmployeeId extends Identifier {

    public EmployeeId(UUID value) {
        super(value);
    }

    public EmployeeId() {
        super();
    }

    @Override
    public void validateState(UUID value) {
        if (isNull(getValue())) {
            throw new DomainException(ErrorMsg.EMPLOYEE_ID_EMPTY.getMessage());
        }
        if (!isIdFormat(value.toString())) {
            throw new DomainException(ErrorMsg.INVALID_ID_FORMAT.getMessage());
        }
    }

}