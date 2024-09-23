package io.santiagovogit.carwashmetro.domain.error;

public enum ErrorType {

    USER_ID_EMPTY("El ID de usuario no puede estar vacío"),
    USER_FIRSTNAME_EMPTY("El primer nombre no puede estar vacío"),
    USER_LASTNAME_EMPTY("El segundo nombre no puede estar vacío"),
    USER_STATUS_EMPTY("El tipo de estado de un usuario no puede estar vácio"),
    EMAIL_ALREADY_EXISTS("Este email ya se encuentra asociado a otro usuario"),
    EMAIL_EMPTY("El correo electrónico no puede estar vacío"),
    INVALID_EMAIL_FORMAT("Formato de correo electrónico inválido."),
    PHONE_NUMBER_EMPTY("El número de teléfono no puede estar vacío"),
    INVALID_PHONE_NUMBER_FORMAT("Formato de número de teléfono inválido."),
    DNI_NUMBER_EMPTY("El número de identificación no puede estar vacío"),
    INVALID_DNI_NUMBER_FORMAT("Formato de documento inválido."),
    DNI_TYPE_EMPTY("El tipo de documento no puede estar vacío"),
    USER_ROLE_EMPTY("El tipo de rol de usuario no puede estar vacío"),

    EMPLOYEE_POSITION_EMPTY("La posición del empleado no puede estar vacía"),
    EMPLOYEE_STATUS_EMPTY("El estado del empleado no puede estar vacío"),
    INVALID_SALARY_FORMAT("Formato de salario inválido."),
    INVALID_SALARY_RANGE("Rango de salario inválido"),
    SALARY_NULL("El salario no puede ser nulo"),

    INVALID_LICENSE_PLATE_FORMAT("Formato de placa de vehículo inválido."),
    INVALID_MODEL_FORMAT("Formato de modelo de vehículo inválido."),
    VEHICLE_TYPE_EMPTY("El tipo de vehículo no puede estar vacío"),
    VEHICLE_ID_EMPTY("El id de vehículo no puede ser nulo"),

    CELL_STATUS_EMPTY("El tipo de esta de la celda no puede estar vacío"),
    CELL_ID_EMPTY("El id de celda no puede ser nulo"),
    CELL_ALREADY_EXIST("Esta celda ya existe"),

    RESERVATION_STATUS_EMPTY("El tipo de estado de una reserva no puede estar vacío"),

    SPACE_NUMBER_EMPTY("El número de espacio de celda no puede estar vacío"),
    INVALID_SPACE_NUMBER("Número de espacio de celda inválido"),
    INVALID_CELL_STATUS("Tipo de estado de celda inválido"),
    INVALID_VEHICLE_TYPE("Tipo de vehículo inválido"),
    INVALID_DNI_TYPE("Tipo de documento inválido"),
    INVALID_NAME_FORMAT("Formato de nombre u apellido inválido"),
    INVALID_USER_ROLE("Tipo de rol de usuario inválido"),
    INVALID_EMPLOYEE_POSITION("Tipo de posición de empleado inválida"),
    INVALID_EMPLOYEE_STATUS("Tipo de estado de empleado inválido"),
    INVALID_RESERVATION_STATUS("Tipo de estado de reserva inválido"),
    INVALID_USER_STATUS("Tipo de estado de usuario inválido"),
    EMPLOYEE_ALREADY_EXIST("Este usuario ya se encuentra asociado a otro empleado"),
    CELL_NOT_AVAILABLE("Esta ce"),
    VEHICLE_INCOMPATIBLE_WITH_CELL(""),
    RESERVATION_NOT_FOUND(""),
    RESERVATIONS_NOT_FOUND(""),
    VEHICLE_NOT_FOUND(""),
    CELL_NOT_FOUND(""),
    INVALID_RESERVATION_STATUS_CHANGE(""),
    VEHICLES_NOT_FOUND(""),
    USER_NOT_FOUND(""), CELLS_NOT_FOUND(""),
    EMPLOYEE_NOT_FOUND(""), EMPLOYEES_NOT_FOUND(""), USERS_NOT_FOUND(""), VEHICLE_ALREADY_EXISTS();


    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}