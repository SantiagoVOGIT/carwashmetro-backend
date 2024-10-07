package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

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
            throw new DomainException(ErrorMsg.USER_ROLE_EMPTY.getMessage());
        }

        for (UserRole status : UserRole.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_USER_ROLE.getMessage());
    }

}