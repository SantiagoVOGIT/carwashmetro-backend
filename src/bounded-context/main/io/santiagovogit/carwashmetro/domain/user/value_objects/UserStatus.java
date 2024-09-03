package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;

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
        validateNotEmpty(value, ErrorType.USER_STATUS_NULL.getMessage());
        return EnumUtils.fromValue(
                UserStatus.class,
                UserStatus::getValue,
                value,
                ErrorType.INVALID_USER_ROLE.getMessage()
        );
    }

}