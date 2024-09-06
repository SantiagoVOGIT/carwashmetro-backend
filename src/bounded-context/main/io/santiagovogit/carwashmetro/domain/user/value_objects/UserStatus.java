package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import java.util.Arrays;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

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
        if (isEmpty(value)) {
            return null;
        }
        return Arrays.stream(UserStatus.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new DomainException(
                        ErrorType.INVALID_USER_STATUS.getMessage(),
                        String.format(value)
                ));
    }

}