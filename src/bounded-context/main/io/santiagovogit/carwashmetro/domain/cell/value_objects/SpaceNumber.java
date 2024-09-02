package io.santiagovogit.carwashmetro.domain.cell.value_objects;

public enum SpaceNumber {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private final Integer value;

    SpaceNumber(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}