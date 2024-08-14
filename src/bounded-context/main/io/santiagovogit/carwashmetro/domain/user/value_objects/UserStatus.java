package io.santiagovogit.carwashmetro.domain.user.value_objects;

public enum UserStatus {

    ACTIVE("ACTIVO"),
    INACTIVE("INACTIVO"),
    SUSPENDED ("SUSPENDIDO");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}