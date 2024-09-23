package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.isEmpty;

public enum DniType {

    CC("CÉDULA CIUDADANÍA"),
    CE("CÉDULA EXTRANJERÍA"),
    TI("TARJETA IDENTIDAD"),
    TE("TARJETA EXTRANJERÍA");

    private final String value;

    DniType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DniType fromValue(String value) {
        if (isEmpty(value)) {
            return null;
        }

        for (DniType status : DniType.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }

        throw new DomainException(
                ErrorType.INVALID_DNI_TYPE.getMessage(),
                String.format(value)
        );
    }

}