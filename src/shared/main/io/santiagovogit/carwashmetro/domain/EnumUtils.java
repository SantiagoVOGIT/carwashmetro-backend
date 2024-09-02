package io.santiagovogit.carwashmetro.domain;

import java.util.Arrays;
import java.util.function.Function;

public class EnumUtils {

    private EnumUtils(){}

    public static <E extends Enum<E>, V> E fromValue(Class<E> enumClass, V value, Function<E, V> valueExtractor) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> valueExtractor.apply(e).equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró " + enumClass.getSimpleName() + " para el valor: " + value));
    }

}
