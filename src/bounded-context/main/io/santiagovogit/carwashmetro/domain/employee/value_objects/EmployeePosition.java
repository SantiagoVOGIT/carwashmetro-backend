package io.santiagovogit.carwashmetro.domain.employee.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

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
            throw new DomainException(ErrorMsg.EMPLOYEE_POSITION_EMPTY.getMessage());
        }
        for (EmployeePosition status : EmployeePosition.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_EMPLOYEE_POSITION.getMessage());
    }

}