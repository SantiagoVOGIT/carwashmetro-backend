package io.santiagovogit.carwashmetro.domain.error;

public enum ErrorMessage {

    INVALID_DNI_NUMBER_FORMAT("Formato de documento inválido."),
    INVALID_EMAIL_FORMAT("Formato de correo electrónico inválido."),
    INVALID_PHONE_NUMBER_FORMAT("Formato de número de teléfono inválido."),
    INVALID_LICENSE_PLATE_FORMAT("Formato de placa de vehículo inválido."),
    INVALID_NAME_FORMAT("Formato de nombre o apellido inválido."),
    INVALID_SALARY_FORMAT("Formato de salario inválido."),
    INVALID_MODEL_FORMAT("Formato de modelo de vehículo inválido."),
    USER_ID_NULL("El ID de usuario no puede ser nulo"),
    EMPLOYEE_POSITION_NULL("La posición del empleado no puede ser nula"),
    EMPLOYEE_STATUS_NULL("El estado del empleado no puede ser nulo"),
    INVALID_SALARY_RANGE("Rango de salario inválido"),
    EMPLOYEE_CREATION_FAILED("La validación de creación del empleado falló"),
    SALARY_NULL("El salario no puede ser nulo"),
    SPACE_NUMBER_NULL("El número de espacio no puede ser nulo"),
    VEHICLE_TYPE_NULL("El tipo de vehículo no puede ser nulo"),
    CELL_STATUS_NULL("El estado de la celda no puede ser nulo"),
    CELL_ID_NULL("El id de celda no puede ser nulo"),
    VEHICLE_ID_NULL("El id de vehículo no puede ser nulo"),
    RESERVATION_STATUS_NULL("El id de reserva no puede ser nulo"),
    USER_FIRSTNAME_EMPTY("El primer nombre no puede estar vacío"),
    USER_LASTNAME_EMPTY("El segundo nombre no puede estar vacío"),
    DNI_NUMBER_EMPTY("El número de identificación no puede estar vacío"),
    PHONE_NUMBER_EMPTY("El número de teléfono no puede estar vacio"),
    EMAIL_EMPTY("El correo electrónico no puede estar vacio"),
    USER_ROLE_NULL("El rol de usuario no puede ser nulo"),
    DNI_TYPE_NULL("El tipo de documento no puede ser nulo"),
    USER_STATUS_NULL("El estado de un usuario no puede ser nulo"),
    INVALID_SPACE_NUMBER("Número de espacio invalido"),
    CELL_ALREADY_EXIST("Esta celda ya existe");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}