package io.santiagovogit.carwashmetro.domain.cell.value_objects;

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

}