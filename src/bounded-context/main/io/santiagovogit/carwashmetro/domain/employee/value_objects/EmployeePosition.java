package io.santiagovogit.carwashmetro.domain.employee.value_objects;

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

}