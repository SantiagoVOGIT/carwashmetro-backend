package io.santiagovogit.carwashmetro.infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HashMapUtils {

    private HashMapUtils() {}

    private static final String ARGUMENTS_MUST_BE_EVEN = "The number of arguments must be even.";
    private static final String KEYS_MUST_BE_STRINGS = "Keys must be strings.";
    private static final String MAP_KEYS_MUST_BE_STRINGS = "Map keys must be strings.";

    public static Map<String, Object> build(Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException(ARGUMENTS_MUST_BE_EVEN);
        }

        Map<String, Object> result = new LinkedHashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            if (!(keyValues[i] instanceof String key)) {
                throw new IllegalArgumentException(KEYS_MUST_BE_STRINGS);
            }
            Object value = keyValues[i + 1];
            result.put(key, processValue(value));
        }
        return result;
    }

    private static Object processValue(Object value) {
        if (value instanceof Map<?,?> map) {
            return processMap(map);
        }
        if (value instanceof List<?> list) {
            return processList(list);
        }
        return value;
    }

    private static Map<String, Object> processMap(Map<?, ?> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> {
                            if (!(entry.getKey() instanceof String key)) {
                                throw new IllegalArgumentException(MAP_KEYS_MUST_BE_STRINGS);
                            }
                            return key;
                        },
                        entry -> processValue(entry.getValue()),
                        (v1, v2) -> v2,
                        LinkedHashMap::new
                ));
    }

    private static List<Object> processList(List<?> list) {
        return list.stream()
                .map(HashMapUtils::processValue)
                .toList();
    }

}