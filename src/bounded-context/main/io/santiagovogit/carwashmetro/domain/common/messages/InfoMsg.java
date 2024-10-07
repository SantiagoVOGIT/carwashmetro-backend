package io.santiagovogit.carwashmetro.domain.common.messages;

public enum InfoMsg {

    SUCCESS_CREATED_CELL("Celda creada exitosamente"),
    SUCCESS_CREATED_EMPLOYEE("Empleado creado exitosamente"),
    SUCCESS_CREATED_USER("Usuario creado exitosamente"),
    SUCCESS_CREATED_VEHICLE("Vehìculo creado exitosamente"),
    SUCCESS_CREATED_RESERVATION("Reservada creada exitosamente"),
    SUCCESS_COMPLETED_RESERVATION("Reservada completada extiosamente"),
    SUCCESS_CONFIRMED_RESERVATION("Reservada confirmada exitosamente"),
    SUCCESS_REJECTED_RESERVATION("Reserva rechazada exitosamente"),
    SUCCES_CANCELED_RESERVATION("Reserva cancelada exitosamente"),
    SUCCESS_DELETED_EMPLOYEE("Empleado eliminado exitosamente"),
    SUCCESS_UPDATED_EMPLOYEE("Empleado modificado exitosamente");

    private final String message;

    InfoMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
