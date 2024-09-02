package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;

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

    public static UserStatus fromValue(String value) {
        return EnumUtils.fromValue(UserStatus.class, value, UserStatus::getValue);
    }

}