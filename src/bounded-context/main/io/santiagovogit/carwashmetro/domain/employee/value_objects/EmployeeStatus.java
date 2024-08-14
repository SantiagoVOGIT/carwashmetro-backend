package io.santiagovogit.carwashmetro.domain.employee.value_objects;

public enum EmployeeStatus {

    ACTIVE("ACTIVO"),
    INACTIVE("INACTIVO"),
    VACATION("VACACIONES"),
    LEAVE("LICENCIA"),
    SUSPENDED("SUSPENDIDO"),
    RETIRED("RETIRADO");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}