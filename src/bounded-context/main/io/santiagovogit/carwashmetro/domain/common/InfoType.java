package io.santiagovogit.carwashmetro.domain.common;

public enum InfoType {

    SUCCESS_CREATED_CELL("Celda creada exitosamente"),
    SUCCESS_CREATED_EMPLOYEE("Empleado creado exitosamente"),
    SUCCESS_CREATED_USER("Usuario creado exitosamente"),
    SUCCESS_CREATED_VEHICLE("Vehìculo creado exitosamente"),
    SUCCESS_CREATED_RESERVATION("Reservada creada exitosamente");

    private final String message;

    InfoType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
