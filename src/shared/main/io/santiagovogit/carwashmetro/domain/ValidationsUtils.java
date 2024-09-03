package io.santiagovogit.carwashmetro.domain;

import io.santiagovogit.carwashmetro.domain.error.DomainException;

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

    public static void validateNotNull(Object obj, String errorType) {
        if (isNull(obj)) {
            throw new DomainException(errorType);
        }
    }

    public static void validateNotEmpty(String str, String errorType){
        if (isEmpty(str)){
            throw new DomainException(errorType);
        }
    }

}
