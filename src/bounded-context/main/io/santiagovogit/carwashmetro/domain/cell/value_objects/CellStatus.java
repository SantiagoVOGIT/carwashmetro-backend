package io.santiagovogit.carwashmetro.domain.cell.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.common.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum CellStatus {

    AVAILABLE("DISPONIBLE"),
    OCCUPIED("OCUPADA"),
    MAINTENANCE("MANTENIMIENTO"),
    RESERVED("RESERVADA"),
    INACTIVE("INACTIVA");

    private final String value;

    CellStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CellStatus fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (CellStatus status : CellStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorType.INVALID_CELL_STATUS.getMessage());
    }

}