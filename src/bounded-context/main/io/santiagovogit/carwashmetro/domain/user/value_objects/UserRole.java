package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import java.util.Arrays;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

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
        if (isEmpty(value)) {
            return null;
        }
        return Arrays.stream(UserRole.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new DomainException(
                        ErrorType.INVALID_USER_ROLE.getMessage(),
                        String.format(value)
                ));
    }

}