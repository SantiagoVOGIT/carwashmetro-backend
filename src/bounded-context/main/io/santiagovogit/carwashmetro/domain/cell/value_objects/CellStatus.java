package io.santiagovogit.carwashmetro.domain.cell.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;

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
        validateNotEmpty(value, ErrorType.CELL_STATUS_NULL.getMessage());
        return EnumUtils.fromValue(
                CellStatus.class,
                CellStatus::getValue,
                value,
                ErrorType.INVALID_CELL_STATUS.getMessage());
    }

}