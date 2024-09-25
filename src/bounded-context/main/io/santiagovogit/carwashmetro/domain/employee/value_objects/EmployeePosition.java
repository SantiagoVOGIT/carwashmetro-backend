package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum EmployeePosition {

    MANAGER("GERENTE"),
    CASHIER("CAJERO"),
    CAR_WASHER("ASISTENTE DE LAVADO"),
    MAINTENANCE("MANTENIMIENTO"),
    CUSTOMER_SERVICE("SERVICIO AL CLIENTE");

    private final String value;

    EmployeePosition(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EmployeePosition fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (EmployeePosition status : EmployeePosition.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorType.INVALID_EMPLOYEE_POSITION.getMessage());
    }

}