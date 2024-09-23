package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum EmployeeStatus {

    ACTIVE("ACTIVO"),
    INACTIVE("INACTIVO"),
    VACATION("VACACIONES"),
    LEAVE("LICENCIA"),
    SUSPENDED("SUSPENDIDO"),
    RETIRED("RETIRADO");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EmployeeStatus fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }

        throw new DomainException(
                ErrorType.INVALID_EMPLOYEE_STATUS.getMessage(),
                String.format(value)
        );
    }

}