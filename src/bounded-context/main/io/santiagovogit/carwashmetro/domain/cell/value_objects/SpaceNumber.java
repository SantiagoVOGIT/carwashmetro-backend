package io.santiagovogit.carwashmetro.domain.cell.value_objects;

public enum SpaceNumber {

    SPACE_ONE("1"),
    SPACE_TWO("2"),
    SPACE_THREE("3"),
    SPACE_FOUR("4"),
    SPACE_FIVE("5"),
    SPACE_SIX("6"),
    SPACE_SEVEN("7"),
    SPACE_EIGHT("8"),
    SPACE_NINE("9"),
    SPACE_TEN("10");

    private final String value;

    SpaceNumber(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}