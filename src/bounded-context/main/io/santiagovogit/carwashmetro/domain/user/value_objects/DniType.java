package io.santiagovogit.carwashmetro.domain.user.value_objects;

import io.santiagovogit.carwashmetro.domain.EnumUtils;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

import static io.santiagovogit.carwashmetro.domain.ValidationsUtils.validateNotEmpty;

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
        validateNotEmpty(value, ErrorType.DNI_TYPE_NULL.getMessage());
        return EnumUtils.fromValue(
                DniType.class,
                DniType::getValue,
                value,
                ErrorType.INVALID_DNI_TYPE.getMessage()
        );
    }

}