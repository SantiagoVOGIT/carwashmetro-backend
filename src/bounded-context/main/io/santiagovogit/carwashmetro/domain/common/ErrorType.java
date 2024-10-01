
package io.santiagovogit.carwashmetro.domain.common;

public enum ErrorType {

    USER_ID_EMPTY("El ID de usuario es requerido"),
    USER_FIRSTNAME_EMPTY("El nombre es requerido"),
    USER_LASTNAME_EMPTY("El apellido es requerido"),
    USER_STATUS_EMPTY("El estado del usuario es requerido"),
    USER_ROLE_EMPTY("El rol del usuario es requerido"),
    INVALID_USER_STATUS("El estado del usuario es inválido"),
    INVALID_USER_ROLE("El rol de usuario es inválido"),
    USER_NOT_FOUND("El usuario no fue encontrado"),
    USERS_NOT_FOUND("No se encontraron usuarios"),

    EMAIL_EMPTY("El email es requerido"),
    EMAIL_ALREADY_EXISTS("El email ya está en uso"),
    INVALID_EMAIL_FORMAT("El formato del email es inválido"),

    PHONE_NUMBER_EMPTY("El número de teléfono es requerido"),
    INVALID_PHONE_NUMBER_FORMAT("El formato del número de teléfono es inválido"),

    DNI_NUMBER_EMPTY("El número de identificación es requerido"),
    DNI_TYPE_EMPTY("El tipo de documento de identidad es requerido"),
    INVALID_DNI_NUMBER_FORMAT("El formato del número de identificación es inválido"),
    INVALID_DNI_TYPE("El tipo de documento de identidad es inválido"),

    EMPLOYEE_POSITION_EMPTY("La posición del empleado es requerida"),
    EMPLOYEE_STATUS_EMPTY("El estado del empleado es requerido"),
    INVALID_EMPLOYEE_POSITION("La posición del empleado es inválida"),
    INVALID_EMPLOYEE_STATUS("El estado del empleado es inválido"),
    EMPLOYEE_ALREADY_EXIST("El empleado ya existe"),
    EMPLOYEE_NOT_FOUND("El empleado no fue encontrado"),
    EMPLOYEES_NOT_FOUND("No se encontraron empleados"),

    SALARY_NULL("El salario es requerido"),
    INVALID_SALARY_FORMAT("El formato del salario es inválido"),
    INVALID_SALARY_RANGE("El salario está fuera del rango permitido"),

    VEHICLE_ID_EMPTY("El ID del vehículo es requerido"),
    VEHICLE_TYPE_EMPTY("El tipo de vehículo es requerido"),
    INVALID_LICENSE_PLATE_FORMAT("El formato de la placa del vehículo es inválido"),
    INVALID_MODEL_FORMAT("El formato del modelo del vehículo es inválido"),
    INVALID_VEHICLE_TYPE("El tipo de vehículo es inválido"),
    VEHICLE_NOT_FOUND("El vehículo no fue encontrado"),
    VEHICLES_NOT_FOUND("No se encontraron vehículos"),
    VEHICLE_ALREADY_EXISTS("El vehículo ya existe"),

    CELL_ID_EMPTY("El ID de la celda es requerido"),
    CELL_STATUS_EMPTY("El estado de la celda es requerido"),
    SPACE_NUMBER_EMPTY("El número de espacio es requerido"),
    INVALID_SPACE_NUMBER("El número de espacio es inválido"),
    INVALID_CELL_STATUS("El estado de la celda es inválido"),
    CELL_ALREADY_EXIST("La celda ya existe"),
    CELL_NOT_FOUND("La celda no fue encontrada"),
    CELLS_NOT_FOUND("No se encontraron celdas"),
    CELL_NOT_AVAILABLE("La celda no está disponible"),

    RESERVATION_STATUS_EMPTY("El estado de la reserva es requerido"),
    INVALID_RESERVATION_STATUS("El estado de la reserva es inválido"),
    RESERVATION_NOT_FOUND("La reserva no fue encontrada"),
    RESERVATIONS_NOT_FOUND("No se encontraron reservas"),
    INVALID_RESERVATION_STATUS_CHANGE("El cambio de estado de la reserva no es válido"),

    INVALID_NAME_FORMAT("El formato del nombre o apellido es inválido"),
    VEHICLE_INCOMPATIBLE_WITH_CELL("El vehículo no es compatible con la celda"),
    INVALID_ID_FORMAT("Formato de id inválido");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
