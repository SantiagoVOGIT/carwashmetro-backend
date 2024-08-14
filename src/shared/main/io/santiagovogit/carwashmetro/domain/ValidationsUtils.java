package io.santiagovogit.carwashmetro.domain;

import io.santiagovogit.carwashmetro.domain.error.DomainException;
import io.santiagovogit.carwashmetro.domain.error.ErrorType;

public class ValidationsUtils {

    private ValidationsUtils() {}

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static void validateNotNull(Object obj, String errorMessage) {
        if (isNull(obj)) {
            throw new DomainException(
                    ErrorType.VALIDATION_ERROR,
                    errorMessage
            );
        }
    }

}
