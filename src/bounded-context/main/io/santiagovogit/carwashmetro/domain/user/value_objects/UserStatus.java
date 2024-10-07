package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.DomainException;
import io.santiagovogit.carwashmetro.domain.common.messages.ErrorMsg;

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
            throw new DomainException(ErrorMsg.USER_STATUS_EMPTY.getMessage());
        }
        for (UserStatus status : UserStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new DomainException(ErrorMsg.INVALID_USER_STATUS.getMessage());
    }

}