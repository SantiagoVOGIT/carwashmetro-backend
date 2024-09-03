package io.santiagovogit.carwashmetro.domain;

import io.santiagovogit.carwashmetro.domain.error.DomainException;

import java.util.Arrays;
import java.util.function.Function;

public class EnumUtils {

    private EnumUtils(){}

    public static <E extends Enum<E>, V> E fromValue(Class<E> enumClass, Function<E, V> valueExtractor, V value, String errorSupplier) {
        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> valueExtractor.apply(e).equals(value))
                .findFirst()
                .orElseThrow(() -> new DomainException(errorSupplier));
    }

}
