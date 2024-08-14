package io.santiagovogit.carwashmetro.domain.user.value_objects;

public enum UserRole {

    ADMIN("ADMINISTRADOR"),
    USER("USUARIO");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}