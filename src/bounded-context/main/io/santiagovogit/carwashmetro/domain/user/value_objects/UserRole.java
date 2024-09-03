package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;

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

    public static UserRole fromValue(String value) {
        validateNotEmpty(value, ErrorType.USER_ROLE_NULL.getMessage());
        return EnumUtils.fromValue(
                UserRole.class,
                UserRole::getValue,
                value,
                ErrorType.INVALID_USER_ROLE.getMessage()
        );
    }

}