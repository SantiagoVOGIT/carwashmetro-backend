package io.santiagovogit.carwashmetro.domain;

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

}
